Here's a super quick & dirty I rattled-off between turns playing Catan. After playing a fair bit, we've grown a bit untrusting of our dice, so we're now logging. This is practically pseudo-code, though, it works enough.

I'd like to burn this little thing down and expand to something much bigger/nicer.

<H1>Use</H1>
This isn't really meant for general consumption, but use would be:
<OL>
<LI>Manually type each dice roll sum (an integer) in to a text file. One line per roll.</LI>
<LI>Invoke via <pre>cat [mydicefile.txt] | ./run.sh</pre></LI>
</OL>

<H2>Sample Output</H2>
Here's sample output from an actual Catan game:
<pre>
There were 43 samples, with an average of: 6.9534883
3: 3 occurences
4: 3 occurences
5: 9 occurences
6: 5 occurences
7: 6 occurences
8: 2 occurences
9: 7 occurences
10: 6 occurences
11: 2 occurences
</pre>

And here's another actual game's output:
<pre>
There were 78 samples, with an average of: 7.192307
3: 2 occurences
4: 12 occurences
5: 9 occurences
6: 5 occurences
7: 14 occurences
8: 13 occurences
9: 11 occurences
10: 4 occurences
11: 5 occurences
12: 3 occurences
</pre>
