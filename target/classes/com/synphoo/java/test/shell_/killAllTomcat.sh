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
 echo "============= kill success"