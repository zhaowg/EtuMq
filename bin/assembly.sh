#!/bin/bash

echo "===========begin assembly groupTiming=============="

param=""

case $1 in
    "help")
        echo "param [dev test prod help]"
        exit;
        ;;
    "dev")
        param="dev"
        ;;
    "test")
        param="test"
        ;;
    "prod")
        param="prod"
        ;;
    *)
        
        echo "param [dev test tprod help]"
        exit;
        ;;
esac

assemblyParam=""

if [ "$param" != "" ]
then
    assemblyParam="-P"${param}
fi

tagName=TT_Server_Notice_${param}_5.0.0
tagTime=`date "+%Y%m%d%H%M"`
tagType=.tar.gz

echo `date "+%Y%m%d %H:%M:%S"`" mvn -f../pom.xml clean assembly:assembly ${assemblyParam} ..................."
mvn -f../pom.xml clean assembly:assembly ${assemblyParam}

mvName(){
    tagName=${tagName}_${tagTime}${tagType}
    
    echo `date "+%Y%m%d %H:%M:%S"`" mv ../target/TTNotice*${tagType} ./target/${tagName}  ......................."
    mv ../target/TTNotice*${tagType} ../target/${tagName}
}

ls ../target/TTNotice*${tagType}
if [ "$?" == "0" ]
then
   mvName
fi

