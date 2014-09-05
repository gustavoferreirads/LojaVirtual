#!/bin/bash
if [ "$1" = "-drop" ] 
then
echo "dropping mysql database"
mysql << EOF
drop database if exists LaaS;
create database LaaS collate latin1_swedish_ci;
quit
EOF
fi
for i in $(find ./migrations -type f | sort)
do
	echo "rodando arquivo $i"
	java -jar -Dfile.encoding=UTF-8 liquibase-3.1.1.jar --driver=com.mysql.jdbc.Driver  --changeLogFile=migrations/$(basename "$i") --url="jdbc:mysql://localhost:3306/LaaS" --classpath=mysql-driver.jar  --username=root  --password=root  update
done
