# Lab5


Stones. Determine the hierarchy of precious and semiprecious stones. Select stones for necklaces. Search for stones in the necklace that match the specified range of transparency parameters.
Implement the ability to sort found products:
- By total weight (in carats)
- At cost
- The implementation of sorting should provide the ability to sort both in descending and ascending order


Task description
- You need to create a class - Manager that will contain logic (example for option 1):
- Realize the search for goods that can be bought for a girl in the autumn period and realize the possibility of sorting the found goods:
  1. at a price
  2. by size
- The implementation of sorting should provide the ability to sort both in descending and ascending order



- Use the built-in sorting methods available in Java to sort
- Sorting should be implemented in a separate method
- The code does not contain static methods / attributes. Only one static method is allowed - void
- Code must use enum type (if necessary)




Convert the project with code 2-3 so that its assembly can be used with maven.
At the same time it is necessary to make the command of merging of previous works in master
Important: Build the project with the mvn clean package console command

You can generate pom.xml using the maven command (console research):

mvn archetype:generate -DgroupId=ua.lviv.iot -DartifactId=work -Dversion=1.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false

It is necessary to write modular tests for the code of laboratory previous tasks and to reach a level of coverage by tests of 80%. Obviously, the ideal 
coverage is 100% (ie each line of code is covered by tests). It is also obvious that writing tests takes a considerable amount of time, which is always lacking. One way 
to avoid this problem is the TDD approach. For this laboratory compromise value will be coverage by tests at the level of 80%
