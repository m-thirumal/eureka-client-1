# eureka-client-1

Actuator dependency is must for client load balancing

Eureka client load balancing with feign, ribbon and spring cloud load balancer

# Required to run the following projects
1. https://github.com/M-Thirumal/eureka-server
2. https://github.com/M-Thirumal/eureka-client-2


# To Create jar
mvn clean package -DskipTests=true

# Run as a jar from terminal
java -jar target/eureka-client-1-0.0.1-SNAPSHOT.jar
