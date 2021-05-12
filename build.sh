#!/bin/sh

./mvnw clean package -DskipTests
docker build --tag spring-quartz:1.0.0 .
