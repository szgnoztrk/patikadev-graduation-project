# Gittigidiyor Java Spring Bootcamp Grauduation Project

## How to Run?
* Clone this repository
* What do you need?
  * Java IDE(Intellij IDEA)
  * JDK 1.8
  * Maven 3.x
  * Mysql Server
 
### MYSQL Server
* CREATE DATABASE graduation;

### SPRING BOOT
* 1 - **eureka-server Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/eureka-server-1.0.0.jar
  ```
  
* 2 - **config-server Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/config-server-1.0.0.jar
  ```
  * Check the stdout or boot_example.log file to make sure no exceptions are thrown
  
* 3 - **customer-service Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/customer-service-1.0.0.jar
  ```
  
* 4 - **score-service Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/score-service-1.0.0.jar
  ```
  
* 5 - **sms-service Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/sms-service-1.0.0.jar
  ```
  
* 6 - **apply-service Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/apply-service-1.0.0.jar
  ```

  ## About Services
  * Eureka Server
  * Config Server
  * Customer Service
  * Score Service
  * Sms Service
  * Apply Service
