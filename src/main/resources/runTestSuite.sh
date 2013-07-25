#!/bin/bash

if [ ! -f setupTestEnv.sh ];
then
    export SMART_PATH=$HOME/.m2/repository/
    export SMART_VERSION=1.0-SNAPSHOT
fi

if [ -f setupTestEnv.sh ];
then
    . ./setupTestEnv.sh
fi
###############
#add classpaths to this
#################
CLASSPATH="$SMART_PATH/org/anon/smarttest/$SMARTTEST_VERSION/smarttest-1.0-SNAPSHOT.jar:"
CLASSPATH="$CLASSPATH$SMARTTESTRESOURCES/*:"
CLASSPATH="$CLASSPATH$SMART_PATH/junit/junit/4.10/junit-4.10.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/open/loadgen/1.0-SNAPSHOT/loadgen-1.0-SNAPSHOT.jar:"

echo $CLASSPATH

java -cp $CLASSPATH org.anon.smarttest.run.SuiteRunner $1
