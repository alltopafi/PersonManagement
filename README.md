# PersonManagement

This a project to create a jar to handle person manament and then create a rest service that uses that jar to handle some http request.

[jar service README](https://github.com/alltopafi/PersonManagement/blob/addPostMethod/jar/README.md)

[springboot-rest service README](https://github.com/alltopafi/PersonManagement/blob/addPostMethod/sprintboot/README.md)

#### Todo
I wanted experince with newer CI/CD tools
I choose to do this with docker and google cloud to run CI/CD


Deplyed version of the rest service on Google's App Engine is at:  **NOTE:** So far I have to push this from my local machine.
https://personmanagement.appspot.com/personmanagement/swagger-ui.html#/  

#### CI FLOW 
1. Docker container is created and copies the contents of the repo over
2. Move to jar projects root and builds the jar using maven 
3. installs the resulting jar to images local maven repo
4. Move to the springboot project and again build this project with maven

If any test failures or thresholds are not met the build will fail (seems CI failure is on any non-zero exit code)