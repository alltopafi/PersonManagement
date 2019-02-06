FROM maven:3.5.2-jdk-8-alpine
COPY ./ /personManagementTemp/
WORKDIR /personManagementTemp/jar
RUN mvn clean install \
&& mvn install:install-file -Dfile=/personManagementTemp/jar/target/personManagement-1.0.0.jar -DgroupId=alltop.personmanagement -DartifactId=personManagement -Dversion=1.0.0 -Dpackaging=jar \
&& cd /personManagementTemp/springboot \
&& mvn clean install
