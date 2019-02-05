# PersonManagement

#### Build project
From the directory PersonManagement/jar
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

**Notes:**
*  Date is expected to be passed as space comma or pipe delimited list (delimiters may be mixed withing file or even line of date), and the date must follow the format MM/dd/YYYY
Ex.
  * If two rows contain the same values only one row will be displayed in the output.

```Targaryen, daenerys, female, black, 01/20/1970
SNOW, JON, male, black, 01/19/1971
DrOgO KhAL male Brown 11/24/1974
Lannister Tyrion male blue 01/01/1968
STARK | ARYA | FEMALE | PINK | 01/13/1984
Seaworth | Davos | male | green, 09/20/1941
```
 
4. User is given a prompt to choose from display options
        * Output 1 – sorted by gender (females before males) then by last name ascending.
        * Output 2 – sorted by birth date, ascending.
        * Output 3 – sorted by last name, descending.
5. The sorted data is outputed to the screen for the user to review.