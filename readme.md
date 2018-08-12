# Cucumber practice

Cucumber tests written on java with help of junit 4, selenide and allure. 
Lastest webdriver will be downloaded automattically. The result is gathered to Allure report, 
so it's easy to understand what's going on in result. If test fails there's attached screenshot in tearDown step.


## Requirements

JDK 1.8, Maven 3

## Usage
To run tests use: 
```
mvn clean test
```
Default browser is Chrome. To run tests in firefox add additional parameter:
```
mvn clean test -Dbrowser=firefox
```
To build allure report use:
```
mvn site
```
Report is located in target/site directory, to check it out open ```allure-maven.html``` in firefox

