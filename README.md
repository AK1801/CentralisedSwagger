# CentralisedSwagger
Microservices with Gateway and centralised Swagger:

The requirement was to have a centralized swagger i.e. instead of having different swagger for each micro-services,
we should have a single point from where we can get the swagger definition of each microservice.

Plan of Execution:
        
        1- Two microservices are created, where first one is simply calling the second microservice 
        which will give "Hello World" message.
        2- We have Eureka Service Registry, where each MS is registered.
        3- We have defined Gateway(Spring Cloud Gateway) which will be the point of contact for everyone.
        4- Now we want swagger definition for each microservice to be held at one place, and the best place would be 
        Gateway.
       
Implementation: 

        1- Implement SwaggerResourcesProvider interface
        2- Add SwaggerResource-----using DiscoveryClient
        3- Get all services-----For each service---fetch the jsonContent
        4- Add it to a HashMap where key represents the serviceid and value represents the json content.
        5- Now to make it dynamic we need to re-fetch the json content after a fixed interval of time for that we use Scheduling.
