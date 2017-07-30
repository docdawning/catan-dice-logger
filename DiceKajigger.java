import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashMap;

class DiceKajigger {
	private static final String EPISODE_PREFIX="episode";
	private static final String EPISODE_POSTFIX=".txt";
	
	public static void main(String[] args) {
		DiceKajigger dk = new DiceKajigger();
		dk.go(args);
	}

	private void go(String[] args) {
		if (args.length < 1) {
			performDataCollection(getNextEpisodeFile(), true, true);
		} else {
			File possibleExistingEpisodeFile = new File(args[1]);
			if (possibleExistingEpisodeFile.exists()) performDataCollection(possibleExistingEpisodeFile, false, false);
			else {
				System.out.println("Gave parameters, but like.. The first one isn't a file and that's the only thing I know how to act upon.");
			}
			//args were given
		}
	}

	private void performDataCollection(File episodeFile, boolean writeFile, boolean promptForInput) {
		HashMap<Integer,Integer> statMap = new HashMap<Integer,Integer>();
		System.out.println("Recording to episode file: "+episodeFile.getName());
		boolean running = true;
		Scanner in = new Scanner(System.in);
		System.out.println("Entering an empty line will end this episode, otherwise input samples one per line");
		int N = 0;
		float avg = 0;
		int lastSample = 0;
		while (running) {
			String input = in.nextLine();
			if (input.equals("")) running = false;
			else {
				int sample = Integer.parseInt(input.replaceAll("[\\D]", ""));
				N++;
				//update rolling average
				if (avg == 0) {
					avg = sample;
				}
				else {
					avg -= (lastSample / N);
					avg += (sample / N);
				} 
				lastSample = sample;
				//System.out.println("Avg: "+avg);
				writeSampleToFile(sample, episodeFile);
		
				Integer key = new Integer(sample);
				Integer keyValue = statMap.get(key);
				if (keyValue == null) statMap.put(key, new Integer(1));
				else {
					statMap.put(key, new Integer(keyValue.intValue() + 1));
				}
				
			}
		}
		System.out.println("\nThere were "+N+" samples, with an average of: "+avg);
		for (Integer key : statMap.keySet()) {
			System.out.println(key+": "+statMap.get(key)+" occurences");
		}
		System.out.println("The end");
	}

	private void writeSampleToFile(int sample, File episodeFile) {
		try {
			FileWriter fw = new FileWriter(episodeFile);
			Integer integer = new Integer(sample);
			fw.write(integer.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println("Couldn't write \""+sample+"\" to file "+episodeFile.getName());
		}
	}

	private File getNextEpisodeFile() {
		int number = 0;
		File episodeFile;
		while ((episodeFile = new File(EPISODE_PREFIX+(String.format("%03d", number++))+EPISODE_POSTFIX)).exists()) {}
		return episodeFile;
	}
}
