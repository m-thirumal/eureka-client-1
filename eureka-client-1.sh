mvn clean package -DskipTests=true
echo 'starting application'
java -jar target/eureka-client-1-0.0.1-SNAPSHOT.jar
