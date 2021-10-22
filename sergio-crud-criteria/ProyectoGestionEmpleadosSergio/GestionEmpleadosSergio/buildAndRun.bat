@echo off
call mvn clean package
call docker build -t SLC/GestionEmpleados .
call docker rm -f GestionEmpleados
call docker run -d -p 9080:9080 -p 9443:9443 --name GestionEmpleados SLC/GestionEmpleados