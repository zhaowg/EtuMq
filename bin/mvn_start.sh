#!/bin/bash
ls ./logs
if [ "$?" != "0" ];then
mkdir -p ./logs
fi

nohup mvn -f../pom.xml jetty:run &> ./logs/startup.log &
echo 'start log web.'
echo '-------------------------- startup logs ---------------------'
sleep 1
tail -f ./logs/startup.log