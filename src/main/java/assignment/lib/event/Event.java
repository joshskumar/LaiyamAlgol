package assignment.lib.event;

public class Event {

    private  int amount;
    private String destProcess;
    private boolean snapshot=false;
    private  int timeTaken;

    public Event (){
        snapshot = true;
    }
    public Event(int amount, String destProcess, int timeTaken){
        this.amount = amount;
        this.destProcess = destProcess;
        this.timeTaken = timeTaken;
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
}
