# Spring-Cloud-Bootstrap
Sample employee application using spring cloud bootstrap
# Steps - 
1. Start Config Server
2. Start Eureka Server
3. Start gateway service.
4. Start employee-service, department-service, salary-service in any order

# Details - 
 Spring cloud config server is used for Externalized configuration(from git)

Eureka Server is used to register and monitor all microservice instances

Feign Client is used to coomunicate between microservices

Spring Cloud Hystrix is used for resiliency, fall back.

Zuul proxy gateway is used for routing/filtering.
