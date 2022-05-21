# Vargrant_Assignment

#To execute the coding part for RCB
#GO to src/test/java/API_testing and then right click --->Run As-->Run configuration--->select the class name as[tests.API_testing]-->apply-->Run


#To execute the wikipedia page for UI
#Go to src/test/java/wikiPediaTest.java class file.
#Now right click on the class name and select Run As
#Now try to select Run configuration--->select the class name as[tests.wikiPediaTest]-->apply-->Run



#Folder Structure

|   .classpath
|   .gitignore
|   .project
|   pom.xml
|   
+---.settings
|       org.eclipse.core.resources.prefs
|       org.eclipse.jdt.core.prefs
|       org.eclipse.m2e.core.prefs
|       
+---src
|   +---main
|   |   +---java
|   |   |   \---pages
|   |   |           BasePage.java
|   |   |           Wikipedia.java
|   |   |           
|   |   \---resources
|   |           log4j2.xml
|   |           payload.json
|   |           
|   \---test
|       +---java
|       |   \---tests
|       |           API_testing.java
|       |           BaseTest.java
|       |           wikiPediaTest.java
|       |           
|       \---resources
|               testng-API.xml
|               
+---target
|   +---classes
|   |   |   log4j2.xml
|   |   |   payload.json
|   |   |   testng-API.xml
|   |   |   
|   |   \---pages
|   |           BasePage.class
|   |           Wikipedia.class
|   |           
|   \---test-classes
|       |   testng-API.xml
|       |   
|       \---tests
|               API_testing.class
|               BaseTest.class
|               wikiPediaTest.class
|               
