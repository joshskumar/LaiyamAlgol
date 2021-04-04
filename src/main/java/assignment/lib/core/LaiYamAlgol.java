package assignment.lib.core;

import assignment.utils.Color;
import assignment.lib.processing.Event;
import assignment.lib.processing.Processor;
import assignment.utils.Constants;
import assignment.utils.EventTracker;

import java.util.Scanner;

public class LaiYamAlgol {

    /**
     * This method is the main class where the inputs for the Algorithm are received
     */
    public void execute(){
        EventTracker global = EventTracker.init();
        Scanner scan = new Scanner(System.in);

        //The number of Processes are entered in this location
        System.out.println("Enter the number of processes : ");
        int noOfProcessor = scan.nextInt();

        Constants globalState = Constants.init();
        Processor processor [] = new Processor[noOfProcessor];

        //iterate based on the number of processes and
        for (int i=0; i < noOfProcessor; i++){

            System.out.println("Enter the intial value for Processor "+(i+1));
            int amount = scan.nextInt();

            globalState.setGlobalstate("processor"+(i+1), Color.WHITE,amount);

            System.out.println("enter the number of events including snapshot");
            int noOfEvents = scan.nextInt();

            Event[] eventArrayList = new Event[noOfEvents];
            Processor process = new Processor("processor"+(i+1));

            //iteration for the number of events and collection of data for each event
            for (int j=0 ; j < noOfEvents; j++){
                String eventName = process.getProcessorName()+(j+1);

                global.setEventList(eventName,false);

                System.out.println("enter 1 if it is send event else it will be considered snapshot");
                int snapshot = scan.nextInt();


                if (snapshot == 1) {
                    System.out.println("Enter the amount which needs to be transferred to the destination processor");
                    int eventAmount = scan.nextInt();

                    System.out.println("Enter the Destination Processor number");
                    int destProcessor = scan.nextInt();

                    System.out.println("Enter the transit time of the Event and enter the time delay after which event should be launched");
                    int transitTaken = scan.nextInt();
                    int launchDelay = scan.nextInt();

                    Event event = new Event(eventName,eventAmount,"processor"+(destProcessor),transitTaken,launchDelay,process.getProcessorName());
                    eventArrayList[j]=event;
                }
                else {
                    System.out.println("This Event is a Snapshot initiator marking ");
                    System.out.println("the Snapshot name is "+ eventName);
                    System.out.println("Enter the time after which the snapshot initiator needs to be there");
                    int launchDelay = scan.nextInt();
                    eventArrayList[j] = new Event(eventName,launchDelay,process.getProcessorName());
                }

            }
            process.setEventList(eventArrayList);
            processor[i] = process;
        }


        for (Processor process : processor){
            process.start();
        }

        //Wait till all the events are completed before collecting the final state of all the processors
        int count = 0;

        // Edit this line if you want to run your Algorithm for more than 5 minutes
        while (!global.getEventList() && count < 300){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }

        System.out.println("the final state of the Processors is : ");
        globalState.displayall();

    }

}
