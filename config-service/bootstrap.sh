#!/bin/bash

while ! nc -z "$LOGSTASH_HOST" "$LOGSTASH_PORT"; do
    echo "Waiting for the Log Service"
    sleep 5
done

java $JAVA_OPTS -jar $ARTIFACT_FILE