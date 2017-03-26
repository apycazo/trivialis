### ==========================================================================
### Docker image for the trivialis provider to run:
### $ mvn clean package && docker build -t trivialis/client .
### $ docker run -d -p 7003:8080 --name trivialis-client trivialis/client
### ==========================================================================

# Use Centos as base layer
FROM centos
# Run system update
RUN yum -y upgrade
# Install openjdk
RUN yum -y install java-1.8.0-openjdk
# Open port
EXPOSE 8080
# Mount tmp volume on host
VOLUME /tmp
# Use '/app' directory instead of root '/' as base path
WORKDIR /app
# Add jar file
ADD /target/trivialis-client-*.jar trivialis-client.jar
# Update 'last modified' field
RUN sh -c 'touch trivialis-client.jar'
# Create the app config file
ARG provider_ip=127.0.0.1
RUN printf "\
server.port: 8080\n\
services.trivialis.provider: http://$provider_ip:8080\n\
security.basic.enabled: false\n\
logging.file: logs/trivialis-client.log\n\
logging.level.com.github.apycazo.trivialis.client: INFO\n\
management.security.enabled: false\n" > application.yml
# On start command
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","trivialis-client.jar"]