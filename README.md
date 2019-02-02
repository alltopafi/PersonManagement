# PersonManagement

#### Build project
```mvn clean install```

While it's not typical I am using ```mvn clean install ```to build project and generate test reports, usually this would be done with profiles or different phases, but for ease I am doing it all in the install phase. I am also not commiting target folder or any generated files, so you would need to pull down the project and build with maven to verify reports (Jacoco results can viewed at target/site/jacoco/index.html and Pit Reports can be viewed at target/pitReport/index.html)

#### Code Quality 
Thresholds have been added for Jacoco and Pit if code is introduced that is below 100% the build will fail.

#### Test Data
There are three test files with test data located in src/main/resources (one for each acceptable input (date seperated by space, comma, or pipe)


#### Flow of application
1. User must give a file with data to the application via an argument (if they do not will throw exception)
2. Extraction of raw data from the input file
3. Conform the data to enter into the Person DTO (lastName firstname gender favoriteColor dateOfBirth) Using a dto to make sorting easier.
4. User is given a prompt to choose from display options
        * Output 1 – sorted by gender (females before males) then by last name ascending.
        * Output 2 – sorted by birth date, ascending.
        * Output 3 – sorted by last name, descending.

