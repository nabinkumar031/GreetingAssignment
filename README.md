# GreetingAssignment

curl -X POST -H "Content-Type: application/json" -d "{\"firstName\":\"Nabin\",\"lastName\":\"Kumar\"}" "http://localhost:8080/hello/post"

curl -X GET "http://localhost:8080/hello/param/nabin" -w "\n"

curl -X GET "http://localhost:8080/hello/query/?name=nabin" -w "\n"



curl -X PUT "http://localhost:8080/hello/put/nabin?lastName=Kumar" -w "\n"




curl -X GET "http://localhost:8080/greeting" -w "\n"



Add gradle dependencies
implementation group: 'org.springframework.boot', name:'spring-boot-starter-data-jpa'
implementation group: 'com.h2database', name: 'h2', version:'1.4.200'

Step 1: H2 Configurations in application.properties file in resource

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect



>curl -X GET "http://localhost:8080/greeting" -w "\n"
{"id":1,"message":"Hello, World!!"}

>curl -X GET "http://localhost:8080/greeting" -w "\n"
{"id":2,"message":"Hello, World!!"}


>curl -X GET "http://localhost:8080/greeting/?name=Nabin" -w "\n"
{"id":2,"message":"Hello, Nabin!!"}

>curl -X GET "http://localhost:8080/greeting/id/2" -w "\n"
Hello, Nabin!!

>curl -X DELETE "http://localhost:8080/greeting/delete/1" -w "\n"
1 not deleted !!

