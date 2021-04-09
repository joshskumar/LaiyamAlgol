LaiyamAlgol
---
This is simulated Lai yam Algorithm in Java for taking snapshot. This code will support n number of processors and n number of events

Intent 
---
This Algorithm has been developed to show the working of it without using any RPC.

Requirements
---
requirement for building the code
- JDK 1.8
- Maven 3.6.3
- OS not constraint provided  you install above for your OS

requirement for running the code
- JRE 1.8
- OS not constraint provided  you install above for your OS

Commands to build code
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

Instruction
---
Make sure you follow the instruction while entering the input data
Please pay attention while entering the data for the below value

"Enter the transit time of the Event and enter the time delay after which event should be launched"
 - Transit time is the time you want your Event to be in transit in the channel
 - Launch time is the time after which the event should be launched 
    
    note : The events are launched sequentially after the wait time.
    
 Sample Execution 
 ---
 ````
 ================Starting Lai Yam=================
 Enter the number of processes : 
 2
 Enter the intial value for Processor 1
 1000
 enter the number of events including snapshot
 3
 enter 1 if it is send event else it will be considered snapshot
 1
 Enter the amount which needs to be transferred to the destination processor
 300
 Enter the Destination Processor number
 2
 Enter the transit time of the Event and enter the time delay after which event should be launched
 3000
 2000
 enter 1 if it is send event else it will be considered snapshot
 0
 This Event is a Snapshot initiator marking 
 the Snapshot name is processor12
 Enter the time after which the snapshot initiator needs to be there
 2000
 enter 1 if it is send event else it will be considered snapshot
 1
 Enter the amount which needs to be transferred to the destination processor
 
 200
 Enter the Destination Processor number
 2
 Enter the transit time of the Event and enter the time delay after which event should be launched
 4000
 5000
 Enter the intial value for Processor 2
 1000
 enter the number of events including snapshot
 2
 enter 1 if it is send event else it will be considered snapshot
 1
 Enter the amount which needs to be transferred to the destination processor
 100
 Enter the Destination Processor number
 1
 Enter the transit time of the Event and enter the time delay after which event should be launched
 5000
 5000
 enter 1 if it is send event else it will be considered snapshot
 1
 Enter the amount which needs to be transferred to the destination processor
 1
 Enter the Destination Processor number
 1
 Enter the transit time of the Event and enter the time delay after which event should be launched
 2000
 2200
 The channel amount from source process processor1 to destination process processor2 is 300
 THIS IS THE SNAPSHOT OF THE PROCESSOR  of the processor :processor1
 Processor : processor1
 Current color : RED
 Current amount : 700
 The channel amount from source process processor2 to destination process processor1 is 100
 the event has reached the destination process : processor2
 Processor : processor2
 Current color : WHITE
 Current amount : 1200
 The channel amount from source process processor2 to destination process processor1 is 1
 The channel amount from source process processor1 to destination process processor2 is 200
 the event has reached the destination process : processor1
 Processor : processor1
 Current color : RED
 Current amount : 501
 the event has reached the destination process : processor1
 Processor : processor1
 Current color : RED
 Current amount : 601
 the event has reached the destination process : processor2
 THIS IS THE SNAPSHOT OF THE PROCESSOR  of the processor on receiving red in processor2
 Processor : processor2
 Current color : RED
 Current amount : 1399
 the final state of the Processors is : 
 Processor : processor2
 Current color : RED
 Current amount : 1399
 Processor : processor1
 Current color : RED
 Current amount : 601
````
# Git hub link 
https://github.com/joshskumar/LaiyamAlgol