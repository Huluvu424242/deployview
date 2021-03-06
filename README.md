# deployview
Overview of currently deployments

## setup tutorials
* spring-boot setup: https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=11&groupId=com.github.huluvu424242&artifactId=deployview&name=deploy-overview&description=overview%20of%20currently%20deployments&packageName=com.github.huluvu424242.deployview&dependencies=devtools,data-rest,thymeleaf,actuator,h2,data-jpa
* h2 config https://www.baeldung.com/spring-boot-h2-database
* jpa rest config https://www.baeldung.com/spring-data-rest-intro
* jpa data typ converter: https://www.baeldung.com/jpa-attribute-converters
* jpa queries: https://www.baeldung.com/spring-data-jpa-query
* ionic framework: https://ionicframework.com/resources/articles/what-is-a-ui-component-library
* @ionic/core in vanilla html: https://www.npmjs.com/package/@ionic/core
* ionic ui-components: https://ionicframework.com/docs/components
* Ionic & Spring Boot: https://developer.okta.com/blog/2017/05/17/develop-a-mobile-app-with-ionic-and-spring-boot
* Thymeleaf Übersicht: https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html

## test start
* ./mvnw spring-boot:run
-> obacht es lässt sich nicht mit Ctrl-C restlos killen, -> TaskManager nutzen, scheint ne Neuerung in spring-boot zu sein

## test urls
* Dashboard: http://localhost:8080/overview
* h2 console:  http://localhost:9000/h2-console/
* health check: http://localhost:9000/health/
* app profile info: http://localhost:9000/profile
* list all artifacts: http://localhost:9000/artifacts
* list of selected artifacts: http://localhost:9000/artifacts/search/findByNamed?name=app
