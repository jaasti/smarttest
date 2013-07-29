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
CLASSPATH="$CLASSPATH$SMART_PATH/org/hamcrest/hamcrest-core/1.1/hamcrest-core-1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/anon/smarttest/1.0-SNAPSHOT/smarttest-1.0-SNAPSHOT.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/open/loadgen/1.0-SNAPSHOT/loadgen-1.0-SNAPSHOT.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hbase/hbase/0.90.6-cdh3u5/hbase-0.90.6-cdh3u5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/google/guava/guava/14.0.1/guava-14.0.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-codec/commons-codec/1.4/commons-codec-1.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-logging/commons-logging/1.1.1/commons-logging-1.1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-lang/commons-lang/2.5/commons-lang-2.5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/log4j/log4j/1.2.16/log4j-1.2.16.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/avro/avro/1.5.4/avro-1.5.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/codehaus/jackson/jackson-mapper-asl/1.8.8/jackson-mapper-asl-1.8.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/codehaus/jackson/jackson-core-asl/1.8.8/jackson-core-asl-1.8.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/xerial/snappy/snappy-java/1.0.3.2/snappy-java-1.0.3.2.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hadoop/hadoop-core/0.20.2-cdh3u5/hadoop-core-0.20.2-cdh3u5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/hadoop/thirdparty/guava/guava/r09-jarjar/guava-r09-jarjar.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-net/commons-net/1.4.1/commons-net-1.4.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-io/commons-io/2.1/commons-io-2.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/mortbay/jetty/jetty/6.1.26/jetty-6.1.26.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/tomcat/jasper-runtime/5.5.23/jasper-runtime-5.5.23.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/javax/servlet/servlet-api/2.5/servlet-api-2.5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-el/commons-el/1.0/commons-el-1.0.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/tomcat/jasper-compiler/5.5.23/jasper-compiler-5.5.23.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/asm/asm/3.2/asm-3.2.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/sun/jersey/jersey-core/1.8/jersey-core-1.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/sun/jersey/jersey-json/1.8/jersey-json-1.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/codehaus/jettison/jettison/1.1/jettison-1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/stax/stax-api/1.0.1/stax-api-1.0.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/sun/xml/bind/jaxb-impl/2.2.3-1/jaxb-impl-2.2.3-1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/javax/xml/bind/jaxb-api/2.1/jaxb-api-2.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/javax/activation/activation/1.1/activation-1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/codehaus/jackson/jackson-jaxrs/1.8.8/jackson-jaxrs-1.8.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/codehaus/jackson/jackson-xc/1.8.8/jackson-xc-1.8.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/sun/jersey/jersey-server/1.8/jersey-server-1.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/javax/servlet/jsp/jsp-api/2.1/jsp-api-2.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/avro/avro-ipc/1.5.4/avro-ipc-1.5.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/velocity/velocity/1.7/velocity-1.7.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/commons-collections/commons-collections/3.2.1/commons-collections-3.2.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/zookeeper/zookeeper/3.3.5-cdh3u5/zookeeper-3.3.5-cdh3u5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/thrift/thrift/0.2.0/thrift-0.2.0.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/jruby/jruby-complete/1.6.0/jruby-complete-1.6.0.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/mortbay/jetty/jsp-2.1/6.1.14/jsp-2.1-6.1.14.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/eclipse/jdt/core/3.1.1/core-3.1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/mortbay/jetty/jsp-api-2.1/6.1.14/jsp-api-2.1-6.1.14.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/mortbay/jetty/servlet-api-2.5/6.1.14/servlet-api-2.5-6.1.14.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/slf4j/slf4j-log4j12/1.6.4/slf4j-log4j12-1.6.4.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/jamon/jamon-runtime/2.3.1/jamon-runtime-2.3.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/com/google/protobuf/protobuf-java/2.3.0/protobuf-java-2.3.0.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/javax/ws/rs/jsr311-api/1.1.1/jsr311-api-1.1.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/oro/oro/2.0.8/oro-2.0.8.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/net/java/dev/jets3t/jets3t/0.6.1/jets3t-0.6.1.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/hsqldb/hsqldb/1.8.0.7/hsqldb-1.8.0.7.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/springframework/spring-core/3.0.5.RELEASE/spring-core-3.0.5.RELEASE.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/springframework/spring-asm/3.0.5.RELEASE/spring-asm-3.0.5.RELEASE.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/httpcomponents/httpclient/4.2.5/httpclient-4.2.5.jar:"
CLASSPATH="$CLASSPATH$SMART_PATH/org/apache/httpcomponents/httpcore/4.2.4/httpcore-4.2.4.j"

#echo $CLASSPATH

java -cp $CLASSPATH org.anon.smarttest.run.SuiteRunner $1
