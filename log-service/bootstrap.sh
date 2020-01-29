#!/bin/bash

/usr/share/logstash/bin/logstash -f /etc/logstash/custom.conf &

service elasticsearch start

/usr/share/kibana/bin/kibana --allow-root
