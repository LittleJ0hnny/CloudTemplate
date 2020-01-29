FROM openjdk:11

MAINTAINER Ostap Kravtsiv

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install netcat

ARG jarName
ARG jarVersion
ARG bootstrapFile
ARG logHost
ARG logPort

ARG ARTIFACT=${jarName:-auth-service}-${jarVersion:-1.0-SNAPSHOT}.jar
ARG BOOTSTRAP_FILE=${bootstrapFile:-bootstrap.sh}
ARG LOGSTASH_HOST_OPTION="LOGSTASH_HOST=$logHost"
ARG LOGSTASH_PORT_OPTION="LOGSTASH_PORT=$logPort"

ADD build/libs/$ARTIFACT .
ADD $BOOTSTRAP_FILE .

ENV JAVA_OPTS="-D$LOGSTASH_HOST_OPTION -D$LOGSTASH_PORT_OPTION"
ENV ARTIFACT_FILE=$ARTIFACT
ENV BOOTSTRAP_FILE=$BOOTSTRAP_FILE

RUN chown 755 $BOOTSTRAP_FILE

ENTRYPOINT bash "$BOOTSTRAP_FILE"