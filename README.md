# LaiyamAlgol
---
This is simulated Lai yam Algorithm in Java for taking snapshot. This code will support n number of processors and n number of events

# Intent 
---
This Algorithm has been developed to show the working of it without using any RPC.

# Requirements
---
requirement for building the code
- JDK 1.8
- Maven 3.6.3
- OS not constraint provided  you install above for your OS

requirement for running the code
- JRE 1.8
- OS not constraint provided  you install above for your OS

# Commands to build code
---
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
- The input argument / values entered check is not done so Program will fail if invalid data type is entered.

# Git hub link 
https://github.com/joshskumar/LaiyamAlgol

# Instruction
---
Make sure you follow the instruction while entering the input data
Please pay attention while entering the data for the below value

"Enter the transit time of the Event and enter the time delay after which event should be launched"
 - Transit time is the time you want your Event to be in transit in the channel
 - Launch time is the time after which the event should be launched 
    
    note : The events are launched sequentially after the wait time.
