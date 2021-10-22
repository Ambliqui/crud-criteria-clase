#!/bin/sh
mvn clean package && docker build -t com.antonio/ejercicioClaseCriteria .
docker rm -f ejercicioClaseCriteria || true && docker run -d -p 9080:9080 -p 9443:9443 --name ejercicioClaseCriteria com.antonio/ejercicioClaseCriteria