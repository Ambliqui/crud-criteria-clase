@echo off
call mvn clean package
call docker build -t com.antonio/ejercicioClaseCriteria .
call docker rm -f ejercicioClaseCriteria
call docker run -d -p 9080:9080 -p 9443:9443 --name ejercicioClaseCriteria com.antonio/ejercicioClaseCriteria