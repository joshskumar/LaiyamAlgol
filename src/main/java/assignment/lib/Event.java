package assignment.lib;

public class Event {

    private  int amount;
    private String destProcess;
    private boolean snapshot=false;

    public Event (){
        snapshot = true;
    }
    public Event(int amount, String destProcess){
        this.amount = amount;
        this.destProcess = destProcess;
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
}
