package assignment.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LaiYamAlgol {

    public void execute(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of processes : ");
        int noOfProcessor = scan.nextInt();
        Constants globalState = Constants.init();
        Processor processor [] = new Processor[noOfProcessor];
        for (int i=0; i < noOfProcessor; i++){
            System.out.println("Enter the intial value for Processor "+(i+1));
            int amount = scan.nextInt();
            globalState.setGlobalstate("processor"+(i+1),Color.WHITE,amount);
            System.out.println("enter the number of events including snapshot");
            int noOfEvents = scan.nextInt();
            Event[] eventArrayList = new Event[noOfEvents];
            Processor process = new Processor("processor"+(i+1));
            for (int j=0 ; j < noOfEvents; j++){
                System.out.println("enter 1 if it is send event else it will be considered snapshot");
                int snapshot = scan.nextInt();
                if (snapshot == 1) {
                    System.out.println("Enter the amount which needs to be transferred to the destination processor");
                    int eventAmount = scan.nextInt();
                    System.out.println("Enter the Destination Processor number");
                    int destProcessor = scan.nextInt();
                    System.out.println("Enter the time in milliseconds for this the event should be in transit");
                    int timeTaken = scan.nextInt();
                    Event event = new Event(eventAmount,"processor"+(destProcessor),timeTaken);
                    eventArrayList[j]=event;
                }
                else {
                    System.out.println("This Event is a Snapshot ");
                    eventArrayList[j] = new Event();
                }

            }
            process.setEventList(eventArrayList);
            processor[i] = process;
        }

        Processing [] processes = new Processing[processor.length];
        for (int i = 0; i < processor.length; i++){
            processes[i] = new Processing(processor[i]);

        }
        for (Processing proces : processes){
            proces.start();
        }
    }

}
