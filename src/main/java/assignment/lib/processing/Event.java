package assignment.lib.processing;

import assignment.utils.*;


public class Event extends Thread{

    private  int amount;
    private String destProcess;
    private boolean snapshot=false;
    private Color color;
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

    public void setEventColor(Color color){
        this.color = color;
    }

    public Color getEventColor(){
        return  this.color;
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

    // The Algorithm implementation is done in this section mainly to maintain the Global state of the Processors
    public void run (){

        ProcessorState sourceState = globalState.getGlobalstate().get(sourceProcessName);

        if (this.getSnapshot() && (sourceState.getColor() == Color.WHITE) ){
            //This Section of the code is for handling snapshots if snapshot of the system is required then the below
            // method should be replace with te snapshot method
            System.out.println(snapshotString + " of the processor :"+ sourceProcessName);

            globalState.setGlobalstate(sourceProcessName,Color.RED,sourceState.getValue());
            globalState.displayGlobalState(sourceProcessName);

        } else {

            //Source Amount is deducted only if the Source and destination process are different.
            if(!sourceProcessName.equalsIgnoreCase(this.getDestProcess())) {
                globalState.setGlobalstate(sourceProcessName, sourceState.getColor(), sourceState.getValue() - this.getAmount());
            }

            //This Sleep is for simulating the event in transit.
            System.out.println("The channel amount from source process "+ sourceProcessName + " to destination process "+this.getDestProcess()+
                               " is "+ this.getAmount() );
            try {
                Thread.sleep(this.getTimeTaken());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //globalState.displayGlobalState(sourceProcessName);
            System.out.println("the event has reached the destination process : " + this.getDestProcess());

            Color sourceStateColor = sourceState.getColor();


            ProcessorState destState = globalState.getGlobalstate().get(this.getDestProcess());
            Color destStateColor = destState.getColor();

            Color color = Color.WHITE;
            if(this.getEventColor() == Color.RED && destStateColor == Color.WHITE){
                // Snapshot is taken if the source Process is red and the destination process is white
                color = Color.RED;
                System.out.println(this.snapshotString + " of the processor on receiving red in "+ this.getDestProcess());
            }
            else if (this.getEventColor() == Color.RED || destStateColor == Color.RED){
                // If the Source or destination color is red then the Color is maintained but snapshot is not taken
                //because as per the Algorithm the snap shot should not be taken in a red Algorithm.
                color = Color.RED;
            }

            //The global state of the Processors is maintained in a global algorithm
            globalState.setGlobalstate(this.getDestProcess(),color,destState.getValue() + this.getAmount());
            globalState.displayGlobalState(this.getDestProcess());

        }
        EventTracker tracker = EventTracker.init();
        tracker.setEventList(this.getEventName(),true);
       // ResetSnapshot.init().reset();
    }
}
