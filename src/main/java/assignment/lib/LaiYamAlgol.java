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
            System.out.println("Enter the intial value greater than 100");
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
                    System.out.println("Enter the amount for the event");
                    int eventAmount = scan.nextInt();
                    System.out.println("Enter the Destination Processor");
                    int destProcessor = scan.nextInt();
                    Event event = new Event(eventAmount,"processor"+(destProcessor+1));
                    eventArrayList[j]=event;
                }
                else {
                    eventArrayList[j] = new Event();
                }

            }
            process.setEventList(eventArrayList);
            processor[i] = process;
        }

        System.out.println(processor.length);
    }

}
