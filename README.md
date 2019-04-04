# spring-microservice-platform

Compile from parent using
	mvn -f pom.xml clean install -DskipTests -U
	
Strat redis on port 6379 (required for request rate limiter in API Gateway)

Start Config Server (spring-microservice-platform\configserver - port 8888:

	java -Dspring.cloud.config.server.encrypt.enabled=false -Dspring.cloud.config.server.git.uri=https://github.com/dabhik/spring-microservice-platform-configuration -Dspring.cloud.config.server.git.username=<USE_YOUR_GIYHUB_USER> -Dspring.cloud.config.server.git.password=<USE_YOUR_GIYHUB_USER> -Dspring.cloud.config.server.git.searchPaths=adminservice,apigateway,servicediscovery,employeeservice -Dspring.cloud.config.server.git.force-pull=true -jar target/configserver-0.0.1-SNAPSHOT.jar

Start Service Discovery (spring-microservice-platform\servicediscovery) - port 8889:

	java -Dspring.profiles.active=dev -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.cloud.config.label=development -jar target/servicediscovery-0.0.1-SNAPSHOT.jar 

Start Admin Service (spring-microservice-platform\adminservice) - port 8890:

	java -Dspring.profiles.active=dev -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.cloud.config.label=development -jar target/adminservice-0.0.1-SNAPSHOT.jar 

Start Employee Service (spring-microservice-platform\employeeservice) - port 8891:

	java -Dspring.profiles.active=dev -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.cloud.config.label=development -jar target/employeeservice-0.0.1-SNAPSHOT.jar 

Start API Gateway (spring-microservice-platform\apigateway) - port 8887:

	java -Dspring.profiles.active=dev -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.cloud.config.label=development -jar target/apigateway-0.0.1-SNAPSHOT.jar 
	
