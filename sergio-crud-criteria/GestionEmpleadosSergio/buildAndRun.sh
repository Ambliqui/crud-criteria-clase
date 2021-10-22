#!/bin/sh
mvn clean package && docker build -t SLC/GestionEmpleados .
docker rm -f GestionEmpleados || true && docker run -d -p 9080:9080 -p 9443:9443 --name GestionEmpleados SLC/GestionEmpleados