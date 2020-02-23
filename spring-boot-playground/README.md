# Spring Framework
- Core -> spring container - manage how beans are created. Factory for creating beans. Manage bean dependencies.
- Infrastructure: aop - Aspect Oriented Programming: logging, security, transactions, etc
- Data Access Layer - jdbc, orm, transactions, jms (for sending asynchronous messages to a Message Broker), oxm 
- Web Layer - servlet, web socket, portlet ... Spring MVC
- Test Layer - unit, integration, mock

# Spring modules
www.spring.io

# Inversion of Control (IoC)
The approach of outsourcing the construction and management objects

Spring is some kind of Object Factory with configuration.

Spring container responsibility
- Create ana manage objects (IoC)
- Inject object's dependencies (Dependency Injection)

Spring container configuration
- XML - old style -> applicationContext.xml
- Java Annotations - modern
- Java Source Code - modern

# Spring development process
1. Configure Spring Beans
2. Create a Spring Container -> ApplicationContext (ClassPatchXmlApplicationContext, AnnotationConfigApplicationContext, others)
3. Retrieve Beans from Spring Contatier 

# Injection types

There are few types injections in Spring
- Constructor Injection
- Setter Injection
- Auto-wiring

# Bean scopes
- singleton (default) - Spring container creates only one instance of the bean. It is cached in memory. 
All requests for the bean will return SHARED reference to the SAME bean. TIP: Always create STATELESS bean!
- prototype - create a new bean instance for each container request
- request - scoped to an HTTP web request. Only used for web apps
- session - scoped to an HTTP web session. Only used for web apps
- global-session - scoped to a global HTTP web session. Only used for web apps

# Bean lifecycle

Container started -> Bean Instantiated -> Dependencies Injected 
-> Internal Spring Processing -> Your Custom Init Method (Bean is Ready for use)
                              -> Container is Shutdown -> Your Custom Destroy Method -> STOP
Bean lifecycle methods/hooks: init-method (@PostConstruct), destroy-method (@PreDestroy)
For "prototype" scoped beans, Spring does not call the destroy method.  Gasp!  

# Project initialization 

https://start.spring.io/

# Spring boot provieds
- embedded tomcat server or other server
- basic configuration - all in one - starters

# How to run app?
mvn spring-boot:run

# Spring Boot Project Structure
## Src folder contains
1. Application entrypoint -> class must be marked by @SpringBootApplication
2. Other classes with logic. IMPORTANT: all classes must be under parent package!
Otherwise we need to configure spring component scanning by using @SpringBootApplication (scanBasePackages = {})

## Test folder contains
1. Spring initialization test.
2. Other tests.

## Resources folder contains
1. static folder for static items such as: pdf, html, css, js, etc.
2. templates folder for templates written for example in Thymeleaf
3. application.properties - properties used by application 
	- server.port - redefine default port (8080)

# Spring dev tools
## Automatic reloading application on code change during development

1. Add dependency to pom.xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-devtools</artifactId>
</dependency>

TIP: To reload application you must rebuild application in IDE. For example in IntelliJ use option Build -> Build Project 

# Spring actuators

It gives an access to healtcheck, monitoring tools and metrics.
To activate it you must add dependency to pom.xml.
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

Endpoints:
	http://localhost:8081/actuator/health - healtcheck
	http://localhost:8081/actuator/info - information about project
		To customize info endpoint you need to add some informaitons to application.properties
			info.app.name=Test app
			info.app.description=My super cool app!!
			info.app.version=1.0.0

By default only /health and /info endpoint are exposed!

Official documentation: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html

# Spring boot properties
Spring boot properties are stored in application.properties

https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html

For example:
- server.port - we can redefine default 8080 port
- server.servlet.context-path - context path of application

# Data persist - CRUD 
There are three options for building CRUD repositories in Spring
- Hibernate API - we need to use session for managing entities
- JPA - here we are using JPA entityManager
- Spring Data JPA - here we must create an interface which will extends JpaRepository interface. By default Spring
will provide basic CRUD operations and more.
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference


# Data REST
Spring provides Spring Data REST functionality. By adding only one dependency to pom file we get REST CRUD endpoints for free.
https://docs.spring.io/spring-data/rest/docs/current/reference/html/#reference

spring.data.rest.base-path=/magic-api - rest context
@RepositoryRestResources(path="/members") - give us a possibility to rename default REST CRUD endpoint name.
Annotation should be used at JpaRepository.   
