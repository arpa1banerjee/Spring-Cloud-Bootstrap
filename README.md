# Spring-Cloud-Bootstrap
Sample employee application using spring cloud bootstrap
Steps - 
1. Start Config Server
2. Start Eureka Server
3. Start gateway service.
4. Start employee-service, department-service, salary-service in any order
5. Spring cloud config server is used for Externalized configuration(from git)
6. Eureka Server is used to register and monitor all microservice instances
7. Feign Client is ised to coomunicate between microservices
8. Spring Cloud Hystrix is used for resiliency, fall back.
9. Zuul proxy gateway is used for routing/filtering.
