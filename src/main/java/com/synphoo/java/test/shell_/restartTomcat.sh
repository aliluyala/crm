#!/bin/sh
#kill tomcat pid
pidlist=`ps -ef|grep tomcat|grep -v "grep"|awk '{print $2}'`
if [ "$pidlist" = "" ]
   then
       echo "============= no tomcat pid alive!"
else
  echo "============= tomcat Id list :\n $pidlist"
  kill -9 $pidlist
  echo "============= KILL $pidlist:"
  echo "============= service stop success"
fi
export JAVA_HOME=/usr/local/jdk1.8.0_60
export JAVA_BIN=/usr/local/jdk1.8.0_60/bin
export JRE_HOME=/usr/local/jdk1.8.0_60/jre
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib/rt.jar
export PATH=$JAVA_HOME/bin:$JRE_HOME/bin:$PATH
#start tomcat
echo "============= start tomcat"
sh /usr/local/apache-tomcat-app-server/bin/startup.sh
echo "============= tomcat - app started"
sh /usr/local/apache-tomcat-ddcash-server/bin/startup.sh
echo "============= tomcat - ddcash started"
sh /usr/local/apache-tomcat-dms-server/bin/startup.sh
echo "============= tomcat - dms started"
sh /usr/local/apache-tomcat-decision-server/bin/startup.sh
echo "============= tomcat - decision started"
sh /usr/local/apache-tomcat-monitor-server/bin/startup.sh
echo "============= tomcat - monitor started"

echo "============= task done.."
