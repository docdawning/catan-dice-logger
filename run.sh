#!/bin/bash
SRC_DIR=CatanDiceLogger/src
MAIN_CLASS=CatanDiceLogger
javac -d build/ $SRC_DIR/$MAIN_CLASS.java
if [ "$?" -ne 0 ] ; then
	echo -e "\nBuild failed. Halting"
	exit -1
fi

echo -e "\nBuild succeeded. Running\n\n"
java -cp build/ $MAIN_CLASS $1 $2 $3 $4 $5 $6

