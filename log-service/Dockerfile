FROM openjdk:11

MAINTAINER Ostap Kravtsiv

ARG BOOTSTRAP_FILE=${bootstrapFile:-bootstrap.sh}
ARG LOGSTASH_CONFIG_FILE=${configFile:-custom.conf}

RUN apt-get update
RUN apt-get -y upgrade
RUN apt-get -y install netcat
RUN apt-get -y install libnss3-tools
RUN wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | apt-key add -
RUN apt-get install apt-transport-https
RUN echo "deb https://artifacts.elastic.co/packages/7.x/apt stable main" | tee -a /etc/apt/sources.list.d/elastic-7.x.list
RUN apt-get update
RUN apt-get -y install logstash
RUN apt-get -y install elasticsearch
RUN apt-get -y install kibana

ADD $BOOTSTRAP_FILE .
ADD $LOGSTASH_CONFIG_FILE ./etc/logstash

ENV BOOTSTRAP_FILE=$BOOTSTRAP_FILE
ENV LOGSTASH_CONFIG_FILE=$LOGSTASH_CONFIG_FILE

RUN chown 755 $BOOTSTRAP_FILE

ENTRYPOINT bash "$BOOTSTRAP_FILE"

