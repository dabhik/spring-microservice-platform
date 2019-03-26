# spring-microservice-platform

Config Server:

java -Dspring.cloud.config.server.encrypt.enabled=false -Dspring.cloud.config.server.git.uri=https://github.com/<ADD_GIT
_USER>/spring-microservice-platform-configuration -Dspring.cloud.config.server.git.username=<ADD_USER> -Dspring.cloud.config.server.git.password=<Add_PASSWORD> -Dspring.cloud.config.server.git.searchPaths=adminservice,apigateway,dev -Dspring.cloud.config.server.git.force-pull=true -Dspring.security.user.name=<CREATE_USER> -Dspring.security.user.password=<CREATE_PASSWORD> -Dserver.port=8888 -jar target/configserver-0.0.1-SNAPSHOT.jar

Admin Service

java -Dspring.profiles.active=dev -Dmanagement.security.enabled=true -Dmanagement.endpoints.web.exposure.include=* -Dspring.security.user.name=<CREATE_USER> -Dspring.security.user.password=<CREATE_PASSWORD>  -Dmanagement.security.role=ACTUATOR -Dsecurity.user.role=ACTUATOR,ADMIN,USER  -Dmanagement.context-path=/manage -Dendpoints.shutdown.enabled=true -Dserver.port=9080 -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.cloud.config.username=<USE_CONFIG_SERVER_USER>  -Dspring.cloud.config.password=<USE_CONFIG_SERVER_PASSWORD> -Dspring.cloud.config.label=development -jar target/adminservice-0.0.1-SNAPSHOT.jar 