### ==========================================================================
### Docker image for the trivialis provider to run:
### $ mvn clean package && docker build -t trivialis/provider .
### $ docker run -d -p 7002:8080 --name trivialis-provider trivialis/provider
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
ADD /target/trivialis-provider-*.jar trivialis-provider.jar
# Update 'last modified' field
RUN sh -c 'touch /app/trivialis-provider.jar'
# Create the app config file
RUN printf "\
server.port: 8080\n\
security.basic.enabled: false\n\
management.security.enabled: false\n" > application.yml
# On start command
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","trivialis-provider.jar"]