### ==========================================================================
### Docker image for the trivialis provider to run:
### $ mvn clean package && docker build -t trivialis/client .
### $ docker run -d -p 9090:9090 --name trivialis-client trivialis/client
### ==========================================================================

# Use Centos as base layer
FROM centos
# Run system update
RUN yum -y upgrade
# Install openjdk
RUN yum -y install java-1.8.0-openjdk
# Open port
EXPOSE 9090
# Mount tmp volume on host
VOLUME /tmp
# Add jar file
ADD /target/trivialis-client-1.0-SNAPSHOT.jar trivialis-client.jar
# Update 'last modified' field
RUN sh -c 'touch /trivialis-client.jar'
# On start command
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/trivialis-client.jar"]