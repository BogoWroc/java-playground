# Project initialization 

https://start.spring.io/

# Spring boot provieds
- embedded tomcat server or other server
- basic configuration - all in one - starters


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