# PersonManagement

Use man clean install to build project and generate test reports (The results can viewed at target/site/jacoco/index.html)

There are three test files with test data located in src/main/resources (one for each acceptable input (date seperated by space, comma, or pipe)


**Flow of application**  
1. User must give a file with data to the application via an argument (if they do not will throw exception)
2. User is given a prompt to choose from display options
	* Output 1 – sorted by gender (females before males) then by last name ascending.
	* Output 2 – sorted by birth date, ascending.
	* Output 3 – sorted by last name, descending. 
