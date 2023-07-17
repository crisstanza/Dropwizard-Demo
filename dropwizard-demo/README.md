# DropwizardDemo

How to start the DropwizardDemo application
---

1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/dropwizard-demo-1.0-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`


Other tests
---

1. http://localhost:8080/hello-world
2. http://localhost:8080/people/Lorem


Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
