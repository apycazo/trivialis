### ==========================================================================
### Docker image for the trivialis provider to run:
### $ mvn clean package && docker build -t trivialis/provider .
### $ docker run -d -p 8080:8080 --name trivialis-provider trivialis/provider
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
# Add jar file
ADD /target/trivialis-provider-1.0-SNAPSHOT.jar trivialis-provider.jar
# Update 'last modified' field
RUN sh -c 'touch /trivialis-provider.jar'
# On start command
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/trivialis-provider.jar"]