#!/bin/bash

while ! nc -z "$CONFIG_HOST" "$CONFIG_PORT"; do
    echo "Waiting for the Config Service"
    sleep 5
done

while ! nc -z "$DISCOVERY_HOST" "$DISCOVERY_PORT"; do
    echo "Waiting for the Discovery Service"
    sleep 5
done

sleep 40

java $JAVA_OPTS -jar $ARTIFACT_FILE