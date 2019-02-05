# PersonManagement-Rest

#### Build project
From the directory Personmanagement/springboot/
```mvn clean install```

There is a dependency with the personManagement-1.0.0.jar I have added it to my local maven repo, but you may need to manually add that jar to your classpath. 

While it's not typical I am using ```mvn clean install ```to build project and generate test reports, usually this would be done with profiles or different phases, but for ease I am doing it all in the install phase. I am also not commiting target folder or any generated files, so you would need to pull down the project and build with maven to verify reports (Jacoco results can viewed at target/site/jacoco/index.html and Pit Reports can be viewed at target/pitReport/index.html)

#### Running the project 
From the directory Personmanagement/springboot/target/
``` java -jar personmanagement-rest-0.0.1-SNAPSHOT.jar```

application will start at this URL
```http://localhost:8080/personmanagement'''

I also included swagger because it allows for a clean interface that will run all of the operations with minimal effort, with the app running you can use the following URL to use that interface
```http://localhost:8080/personmanagement/swagger-ui.html#/```

#### Data persistance 
I create a file on the filesystem where the application is being ran to persit the data. 

**NOTE:** Need to run a post request to insert first otherwise the FIle is not there and will get a file not found exception.


#### Enpoints of application
* POST /records - Post a single data line in any of the 3 formats supported by your existing code
* GET /records/gender - returns records sorted by gender
* GET /records/birthdate - returns records sorted by birthdate
* GET /records/name - returns records sorted by name


**Notes:**
The POST request must follow the date format M/d/YYYY