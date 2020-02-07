generate data model from person.xsd file :

mvn package

build project :

mvn install

deploy projet 

java -jar target\manageServiceWeb.jar

you can see content wsdl file :

http://localhost:8383/personService/ws/person.wsdl

For database you can active H2 with data.sql in resources file. 
And you can active other database with paramteres application.properties file.
For my example I had useed mysql database.
