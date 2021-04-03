package assignment.lib.processing;

import assignment.utils.ProcessorState;
import assignment.utils.Color;
import assignment.utils.Constants;
import assignment.utils.EventTracker;

public class Event extends Thread{

    private  int amount;
    private String destProcess;
    private boolean snapshot=false;
    private  int timeTaken;
    private int launchDelay;
    private String eventName;
    private Constants globalState = Constants.init();
    private String sourceProcessName;
    private final String snapshotString = "THIS IS THE SNAPSHOT OF THE PROCESSOR ";

    public Event (String eventName,int launchDelay,String sourceProcessName){
        this.eventName = eventName;
        this.snapshot = true;
        this.timeTaken = timeTaken;
        this.launchDelay = launchDelay;
        this.sourceProcessName = sourceProcessName;
    }
    public Event(String eventName ,int amount, String destProcess, int timeTaken, int launchDelay,String sourceProcessName){
        this.amount = amount;
        this.destProcess = destProcess;
        this.timeTaken = timeTaken;
        this.launchDelay = launchDelay;
        this.eventName = eventName;
        this.sourceProcessName= sourceProcessName;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getSnapshot(){
        return this.snapshot;
    }

    public String getDestProcess() {
        return destProcess;
    }

    public int getTimeTaken(){
        return timeTaken;
    }

    public int getLaunchDelay(){ return  launchDelay;}

    public String getEventName() {
        return eventName;
    }

    public void run (){

        ProcessorState sourceState = globalState.getGlobalstate().get(sourceProcessName);
        if (this.getSnapshot() && (sourceState.getColor() == Color.WHITE) ){
            System.out.println(snapshotString + " of the processor :"+ sourceProcessName);
            globalState.setGlobalstate(sourceProcessName,Color.RED,sourceState.getValue());
            globalState.displayGlobalState(sourceProcessName);
            System.out.println("the Snapshot name is "+ this.getEventName());
        } else {
            if(!sourceProcessName.equalsIgnoreCase(this.getDestProcess())) {
                globalState.setGlobalstate(sourceProcessName, sourceState.getColor(), sourceState.getValue() - this.getAmount());
            }
            globalState.displayGlobalState(sourceProcessName);
            try {
                Thread.sleep(this.getTimeTaken());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("the event has reached the destination process : " + this.getDestProcess());

            Color sorcestateColor = sourceState.getColor();


            ProcessorState destState = globalState.getGlobalstate().get(this.getDestProcess());
            Color deststateColor = destState.getColor();

            Color color = Color.WHITE;
            if(sorcestateColor == Color.RED && deststateColor == Color.WHITE){
                color = Color.RED;
                System.out.println(snapshot + " of the processor "+ this.getDestProcess());
            }
            else if (sorcestateColor == Color.RED || deststateColor == Color.RED){
                color = Color.RED;
            }

            globalState.setGlobalstate(this.getDestProcess(),color,destState.getValue() + this.getAmount());
            globalState.displayGlobalState(this.getDestProcess());
        }
        EventTracker tracker = EventTracker.init();
        tracker.setEventList(this.getEventName(),true);
    }
}
