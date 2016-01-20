Description

The tests automate the following basic stories in the Gmail platform using java and selenium webdriver.  
1)Create an account
2)Logging in and out
3)Verify the total number of unread emails is accurate
4)Deleting emails from "Tom".
5)Emails can be sent and received
6)Multi-threading (parallel test)  to make the test run

All tests were executed in Ubuntu 14.04 

Basic Configuration and how to run the tests
1)The test project uses  Selenium2 web driver,  the TestNG framework and Maven. Instructions on how to install and configure maven:
https://maven.apache.org/
2)Once maven is installed and configured,  open the project with Eclipse, IntelliJ or any IDE of preference.
3) Open up a command line prompt and go to the root folder of the project and from the root folder execute the following commands for each of the tests :
mvn -Dtest=CreateAccountTest test
mvn -Dtest=SendEmailTest test 
mvn -Dtest=DeleteEmailTest test 
mvn -Dtest=LoginLogOutTest test
mvn -Dtest=VerifyUnreadEmailsTest test 

4) For parallel execution, run: mvn clean install

If you want to run it with another browser other than firefox(Default), pass the parameter -Dbrowser  for every test:

 mvn -Dtest=CreateAccountTest test -Dbrowser=IE
 mvn -Dtest=CreateAccountTest test -Dbrowser=chrome

For IE, please locate in your computer the path to  
IEDriverServer.exe
and configure the path in the file config.properties/variable=IEDriver. 

For chrome, make sure you have Version >=43 installed

