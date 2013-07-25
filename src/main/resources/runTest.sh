#!/bin/bash
./cleanData.sh MyTestTenant hadoop 2181 hadoop:60010
./setupTests.sh $1
./runTestCases.sh $1
