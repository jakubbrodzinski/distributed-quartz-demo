#!/bin/sh

cat docker-compose.yml | docker stack deploy -c - quartz
