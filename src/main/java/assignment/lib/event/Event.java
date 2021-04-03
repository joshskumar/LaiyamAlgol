package assignment.lib.event;

public class Event {

    private  int amount;
    private String destProcess;
    private boolean snapshot=false;
    private  int timeTaken;
    private int launchDelay;
    private String eventName;

    public Event (String eventName){
        snapshot = true;
    }
    public Event(String eventName ,int amount, String destProcess, int timeTaken, int launchDelay){
        this.amount = amount;
        this.destProcess = destProcess;
        this.timeTaken = timeTaken;
        this.launchDelay = launchDelay;
        this.eventName = eventName;
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
}
