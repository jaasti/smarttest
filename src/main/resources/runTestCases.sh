#!/bin/bash

export SMART_PATH=$HOME/.m2/repository/
export SMARTTEST_VERSION=1.0-SNAPSHOT
###############
#add classpaths to this
#################
CLASSPATH="$SMART_PATH/org/anon/smarttest/$SMARTTEST_VERSION/smarttest-1.0-SNAPSHOT.jar:"

java -cp $CLASSPATH org.anon.smarttest.run.TestCaseRunner $1
