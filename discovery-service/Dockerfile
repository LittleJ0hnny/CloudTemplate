FROM openjdk:8u181-jdk

MAINTAINER Ostap Kravtsiv

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install netcat

EXPOSE 8761

ARG ARTIFACT=${jarName:-discovery-service}-${jarVersion:-1.0-SNAPSHOT}.jar
ARG BOOTSTRAP_FILE=${bootstrapFile:-bootstrap.sh}

ADD build/libs/$ARTIFACT $ARTIFACT
ADD $BOOTSTRAP_FILE $BOOTSTRAP_FILE

ENV JAVA_OPTS=""
ENV ARTIFACT_FILE=$ARTIFACT
ENV BOOTSTRAP_FILE=$BOOTSTRAP_FILE

RUN chown 755 $BOOTSTRAP_FILE

ENTRYPOINT bash "$BOOTSTRAP_FILE"