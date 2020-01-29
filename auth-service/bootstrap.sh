#!/bin/bash

while ! nc -z "$MYSQL_HOST" "$MYSQL_PORT"; do
    echo "Waiting for the DB service"
    sleep 5
done

while ! nc -z "$CONFIG_HOST" "$CONFIG_PORT"; do
    echo "Waiting for the Config Service"
    sleep 5
done

while ! nc -z "$DISCOVERY_HOST" "$DISCOVERY_PORT"; do
    echo "Waiting for the Discovery Service"
    sleep 5
done

while ! nc -z "$GATEWAY_HOST" "$GATEWAY_PORT"; do
    echo "Waiting for the Gateway Service"
    sleep 5
done

sleep 10

java $JAVA_OPTS -jar $ARTIFACT_FILE