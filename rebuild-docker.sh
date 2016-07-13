#!/bin/bash

docker ps -a | grep emailserver | awk '{ print $1 }' | xargs docker rm -f

docker rmi emailserverstub_email-client emailserverstub_email-server

./gradlew clean build shadowJar

docker-compose up
