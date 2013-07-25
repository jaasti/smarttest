#!/bin/bash
export SMART_PATH=$HOME/.m2/repository/
export SMARTTEST_VERSION=1.0-SNAPSHOT
export SOLR_HOME=$SMART_PATH/solr-datastore

if [ -f setupEnv.sh ];
then
    . ./setupEnv.sh
fi

###############
#add classpaths to this
#################
CLASSPATH="$SMART_PATH/org/anon/smarttest/$SMARTTEST_VERSION/smarttest-1.0-SNAPSHOT.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/log4j/log4j/1.2.16/log4j-1.2.16.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-logging/commons-logging/1.1/commons-logging-1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-lang/commons-lang/2.5/commons-lang-2.5.jar:"
#these are used in development from the repository
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hbase/hbase/0.90.6-cdh3u5/hbase-0.90.6-cdh3u5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hadoop/hadoop-core/0.20.2-cdh3u5/hadoop-core-0.20.2-cdh3u5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/zookeeper/zookeeper/3.3.6/zookeeper-3.3.6.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hadoop/thirdparty/guava/guava/r09-jarjar/guava-r09-jarjar.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/slf4j/slf4j-api/1.6.1/slf4j-api-1.6.1.jar:"                                                 
CLASSPATH="$CLASSPATH$SMART_PATH/org/slf4j/slf4j-log4j12/1.6.4/slf4j-log4j12-1.6.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/slf4j/slf4j-api/1.6.4/slf4j-api-1.6.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-io/commons-io/1.4/commons-io-1.4.jar:"

echo "Deleting index:"
rm -rf $SOLR_HOME/$1

java -cp $CLASSPATH org.anon.smarttest.data.DataCleaner $1 $2 $3 $4

