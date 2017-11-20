#!/bin/sh

BASE_DIR=$(cd "$(dirname "$0")"; pwd)/
cd $BASE_DIR

GLOBAL_ID=${BASE_DIR}

CUR_APPID=tracker-server
APP_VERSION=1.0

APP_NAME=com.XXX.XXXX.parser.TrackerServer  --修改成你的启动类
APP_PARA=
LOGFILE="stdout.log"

LIBS=./lib

PUB_LIB=""
for jar in `find $LIBS -name "*.jar"`
do
      PUB_LIB="$PUB_LIB:""$jar"
done

JAVACLASSPATH=./conf/:.:$PUB_LIB

JAVABIN=java

curDate=`date '+%G%m%d'`
curTime=`date '+%H%M%S'`

# Functions for all the parameters

function displayHelp()
{       echo '  '
        echo ' Please Attach a parameter when run this shell   '
        echo ' Parameters:'
        echo '      -start  : Start Application in Service Mode(Log to File)'
        echo '      -stop   : Stop The Application'
        echo '      -restart: Restart The Application'
        echo '      -status : Display Running Status of The Application'
        echo '      -version: Display current App Version'
        echo '  '
        echo " Version: $APP_VERSION"
        echo '  '
}

function displayAppStatus()
{
   echo "  "
   echo "Current App["$CUR_APPID"] at [${BASE_DIR}] Status: "
   echo " "

   ps -ef |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME

   echo ""
}

function stopApp()
{
  echo "trying stop app $CUR_APPID ......................"
  #echo '########### stop by user #####' >> ./logs/$LOGFILE.$(date +%F)
  PID=`/bin/ps -ef | grep -v .sh |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME | grep -v grep |awk '{print $2}'`
#  PID=`/bin/ps -ef | grep -v .sh |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME | grep -v console |grep -v grep |awk '{print $2}'`
  if [ ! -z "${PID}" ]; then
    kill -15 $PID
  fi

  sleep 1
  PID=`/bin/ps -ef | grep -v .sh |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME |grep -v console |grep -v grep |awk '{print $2}'`
  if [ ! -z "${PID}" ]; then
    kill -9 $PID
    kill -9 `/bin/ps -ef | grep -v .sh |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME |grep -v console |grep -v grep |awk '{print $2}'`
    sleep 1
  fi

  echo "success stop app $CUR_APPID at [${GLOBAL_ID}] !!!!!!!!!!!!!!!!!!!"
}

function startApp()
{
  echo "trying start app $CUR_APPID ......................"
  mv ./logs/$LOGFILE.$(date +%F) ./logs/$curDate\_$curTime\_$CUR_APPID.log

  JVM_PARAM="
        -server
        -Xmx256M
        -Xms256M
        -Xmn128M
        -XX:PermSize=56M
        -XX:MaxPermSize=128M
        -XX:GCTimeRatio=19
        -XX:+ClassUnloading
        -XX:+UseConcMarkSweepGC
        -Xloggc:log/gc.log
    "
#  $JAVABIN -DAPPID=$CUR_APPID -DGID=$GLOBAL_ID $JVM_PARAM -classpath $JAVACLASSPATH $APPJAVA_ADDPRO  $APP_NAME $APP_PARA >&1 \ | /usr/local/sbin/cronolog "$BASE_DIR"/logs/$LOGFILE.%Y-%m-%d >> /dev/null &
  $JAVABIN -DAPPID=$CUR_APPID -DGID=$GLOBAL_ID $JVM_PARAM -classpath $JAVACLASSPATH $APPJAVA_ADDPRO  $APP_NAME $APP_PARA >>/dev/null &
  echo "success start app $CUR_APPID at [${GLOBAL_ID}] !!!!!!!!!!!!!!!!!!!"
  ps -ef |grep $GLOBAL_ID | grep $CUR_APPID | grep $APP_NAME > pid

  displayAppStatus
}

function restartApp()
{
    stopApp
    sleep 1
    startApp
    exit
}

if [ $# -eq 0 ]; then
    displayHelp
    exit
fi

# Shell Control
if [ $1 = "-start" ]; then
    stopApp
    sleep 1
    startApp
    sleep 2
    displayAppStatus
    exit
fi

if [ $1 = "-stop" ]; then
    stopApp
    sleep 2
    displayAppStatus
    exit
fi


if [ $1 = "-status" ]; then
    displayAppStatus
    exit
fi

if [ $1 = "-restart" ]; then
    restartApp
    exit
fi

if [ $1 = "-version" ]; then
    echo "       version: $APP_VERSION"
    exit
fi