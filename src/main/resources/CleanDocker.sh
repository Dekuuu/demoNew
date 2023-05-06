#!/bin/
imagename=10.0.12.15/dev-test/demo:latest
docker images | grep $imagename &> /dev/null
#如果存在，删除该镜像
if [ $? -eq 0 ]
then
    echo $name" image is existed,we will remove it!!!"
    docker rmi $(docker images | grep $imagename | awk "{print $3}")
fi
