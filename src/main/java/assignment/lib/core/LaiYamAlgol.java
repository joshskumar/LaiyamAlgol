package assignment.lib.core;

import assignment.utils.Color;
import assignment.lib.event.Event;
//import assignment.lib.processor.Processing;
import assignment.lib.processor.Processor;
import assignment.utils.Constants;
import assignment.utils.EventTracker;

import java.util.Scanner;

public class LaiYamAlgol {

    public void execute(){
        EventTracker global = EventTracker.init();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int noOfProcessor = scan.nextInt();
        Constants globalState = Constants.init();
        Processor processor [] = new Processor[noOfProcessor];
        for (int i=0; i < noOfProcessor; i++){
            System.out.println("Enter the intial value for Processor "+(i+1));
            int amount = scan.nextInt();
            globalState.setGlobalstate("processor"+(i+1), Color.WHITE,amount);
            System.out.println("enter the number of events including snapshot");
            int noOfEvents = scan.nextInt();
            Event[] eventArrayList = new Event[noOfEvents];
            Processor process = new Processor("processor"+(i+1));

            for (int j=0 ; j < noOfEvents; j++){
                String eventName = process.getName()+(j+1);
                global.setEventList(eventName,false);
                System.out.println("enter 1 if it is send event else it will be considered snapshot");
                int snapshot = scan.nextInt();
                if (snapshot == 1) {
                    System.out.println("Enter the amount which needs to be transferred to the destination processor");
                    int eventAmount = scan.nextInt();
                    System.out.println("Enter the Destination Processor number");
                    int destProcessor = scan.nextInt();
                    System.out.println("Enter the transit time of the Event anf enter the time delay after which event should be launched");
                    int transitTaken = scan.nextInt();
                    int launchDelay = scan.nextInt();
                    Event event = new Event(eventName,eventAmount,"processor"+(destProcessor),transitTaken,launchDelay);
                    eventArrayList[j]=event;
                }
                else {
                    System.out.println("This Event is a Snapshot initiator marking ");
                    eventArrayList[j] = new Event(eventName);
                }

            }
            process.setEventList(eventArrayList);
            processor[i] = process;
        }


        for (Processor process : processor){
            process.start();
        }
        while (!global.getEventList()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //   System.out.println("the Processors are still executing");
        }

        System.out.println("the final state of the Processors is : ");
        globalState.displayall();

    }

}
