echo 'shutdown web log service ...'
nohup mvn -f../pom.xml jetty:stop &> ./logs/startup.log &
sleep 1
tail -f ./logs/startup.log