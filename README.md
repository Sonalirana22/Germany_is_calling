
## Test Execution Steps:
1. Make sure to have all the software installed in your machine before starting any project. So i have jdk 11, since i am using chrome browser so ChromeDriver installed compatible to your browser version.
2. IDE - I am using VS Code and the Gradle as my build automation tool.
3. To create a project from scratch i have used gradle init cmd and added the Java-Selenium and TestNG dependencies to the bbuild.gradle file.
4. Make a java file and write down all your test script and migrated to TestNG framework using @Test.
5. I have written down 4 scenarios/Testcases so i have set priority where the test methods will run bases on the priority i have set.
6. As you run we can see the TestNG reports generated where it shows whether the tests are pass/fail.

## Assumptions :
1. When trying login with incorrect username and correct password, the message should displayed in such a way that the user will imediatly get to know there is something wrong in the username instead of "Please enter a correct username and password. Note that both fields may be case-sensitive". 

## Additional Information:
 ### Challenges:
 1. My ChromeDriver and browser version was incompatible so browser wasn't opening at the initial stage but worked fine after i updated the cromeDriver.
 2. I was trying configure Extent Report to my project for better visualizing reporting experince but i faced challenges to implement it and due to time shortage i had to adjust with TestNG auto reporting.
