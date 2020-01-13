#!/bin/bash

while ! nc -z "$CONFIG_HOST" "$CONFIG_PORT"; do
    echo "Waiting for the Config Service"
    sleep 5
done

java $JAVA_OPTS -jar $ARTIFACT_FILE