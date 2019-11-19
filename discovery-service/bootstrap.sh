#!/bin/bash

while ! nc -z config-service 8888; do
    echo "Waiting for the Config Service"
    sleep 3
done

java $JAVA_OPTS -jar $ARTIFACT_FILE