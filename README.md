# Trivialis
A simple spring boot rest service for testing APIs. The intention behind this is to have
a sample multi-module project to detail some source organization options.

For this, here I have used the following submodules:

* **trivialis-shared**: A spring factory library, can be autoconfigured on include, and provided some features to
whatever module includes it.
* **trivialis-contract**: This module details the 'contract' required to work with the provider service, namely, the
data models for the API response, as well as the API interface (to create Feign client for the API).
* **trivialis-provider**: The service provider, as specified by the contract.
* **trivialis-client**: Consumer for the provider, uses Feign clients, driven by the contract to deal with the provider.

I have not yet included anything on Eureka service discovery, but it is planned as part of an improved sample, using also 
cloud properties and Hystrix.

## Checking this

This is quite a simple thing, not pretending to provide any actual functionallity, but in case anyone want to see, the 
setup would be as follows:

*Note: using `$BASE` as the directory where the `trivialis` base directory can be found*

**Build** `mvn -f $BASE/pom.xml clean install`

**Start provider** `mvn -f $BASE/trivialis-provider/pom.xml spring-boot:run`

**Start client** `mvn -f $BASE/trivialis-client/pom.xml spring-boot:run`

**Send a query to client** `curl http://127.0.0.1:9090/process` (this will call the provider and show the response).