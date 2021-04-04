# LaiyamAlgol
This is simulated Lai yam Algorithm in Java for taking snapshot. This code will support n number of processors and n number of events

# Intent 
This Algorithm has been developed to show the working of it without using any RPC.

# Requirements
requirement for building the code
- JDK 1.8
- Maven 3.6.3
- OS not constraint provided  you install above for your OS

requirement for running the code
- JRE 1.8
- OS not constraint provided  you install above for your OS

# Commands to build code
To build the Jar file use the following commands
````
mvn clean
mvn package
````
You will find the Jar file in your target folder
command to execute the jar
````
java -jar laiyang-2.0.jar
````
# Limitations
- Reset of the global state after all the Processes have turned red is not implemented because the one who executes this code will know the final state of the algorithm
```
ResetSnapshot.init().reset();
```
The implementation of reset is done in the ResetSnapshot class and if you want you can uncomment the reset line if you are looking to reset the processes when they all turn red

# Git hub link 
https://github.com/joshskumar/LaiyamAlgol
