# Trivialis
A simple spring boot rest service for testing APIs. The intention behind this is to have
a sample multi-module project to detail some source organization options.

For this, I have used the following modules:

* **trivialis-shared**: A spring factory library, can be auto-configured on include, and provided some features to
whatever module includes it.
* **trivialis-contract**: This module details the 'contract' required to work with the provider service, namely, the
data models for the API response, as well as the API interface (to create Feign client for the API).
* **trivialis-provider**: The service provider, as specified by the contract.
* **trivialis-client**: Consumer for the provider, uses Feign clients, driven by the contract to deal with the provider.

I have not yet included anything on Eureka service discovery, but it is planned as part of an improved sample, using also 
cloud properties and Hystrix.

## Checking this

This is quite a simple thing, not pretending to provide any actual functionality, but in case anyone want to see, the 
setup would be as follows:

*Note: using `$BASE` as the directory where the `trivialis` base directory can be found*

**Build** `mvn -f $BASE/pom.xml clean install`

**Start provider** `mvn -f $BASE/trivialis-provider/pom.xml spring-boot:run`

**Start client** `mvn -f $BASE/trivialis-client/pom.xml spring-boot:run`

**Query to client** `curl http://127.0.0.1:9090/process` (this will call the provider and show the response).

## Quick review using docker

Docker container config files and docker-compose config are provided for fast testing. To run through docker compose:

```
$ mvn clean package
$ docker-compose -d --build up
$ curl http://127.0.0.1:9101/users
$ curl http://127.0.0.1:9102/process
```

## Notes

I know that using 'centos' image as base for docker is not very effective, a tad heavy, and the same result
can be achieved using 'alpine' images, but I need to use a centos image for other tests based on 
this repo (which I can't publish here). If this is too heavy for you, you can use 'openjdk-8-jdk-alpine'
(just remember to update the docker files accordingly).

## TODO

There is no need to create an `application.yml` config using docker, a spring profile for docker can be used instead like:

```
spring.application.name: trivialis-client
server.port: 9090
---
spring.profiles: docker
server.port: 8080
logging:
    file: logs/trivialis-client.log
    level:
        com.github.apycazo.trivialis.client: INFO
```

And in the docker file use an entry point like:
```
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","spring.profiles.active=docker,"-jar","trivialis-client.jar"]
```