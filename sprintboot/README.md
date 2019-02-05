# PersonManagement-Rest

#### Build project
From the directory Personmanagement/springboot/
```mvn clean install```

There is a dependency with the personManagement-1.0.0.jar I have added it to my local maven repo, but you may need to manually add that jar to your classpath. 

#### Running the project 
From the directory Personmanagement/springboot/target/
``` java -jar personmanagement-rest-0.0.1-SNAPSHOT.jar```

application will start at this URL
```http://localhost:8080/personmanagement'''

I also included swagger because it allows for a clean interface that will run all of the operations with minimal effort, with the app running you can use the following URL to use that interface
```http://localhost:8080/personmanagement/swagger-ui.html#/```

#### Data persistance 
On application boot up we load a txt file that has been packaged with the jar to persist the data.


#### Enpoints of application
* POST /records - Post a single data line in any of the 3 formats supported by your existing code
* GET /records/gender - returns records sorted by gender
* GET /records/birthdate - returns records sorted by birthdate
* GET /records/name - returns records sorted by name


**Notes:**
The POST request must follow the date format MM/dd/YYYY