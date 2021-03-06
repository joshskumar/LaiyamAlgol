package assignment.lib.processing;


import assignment.utils.Constants;

public class Processor extends Thread {

    private Event event[];
    private String name;

    public Processor(String name){
        this.event = event;
        this.name = name;
    }

    public Event[] getEventList(){
        return event;
    }

    public String getProcessorName(){
        return name;
    }


    public void setEventList(Event event[]){
        this.event = event;
    }


    public void run(){
        for (Event event : this.getEventList()){
            //This Sleep is to simulate the Event triggers in the different times.
            try {
                Thread.sleep(event.getLaunchDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Constants globalState = Constants.init();
            event.setEventColor(globalState.getGlobalstate().get(this.getProcessorName()).getColor());
            event.start();
        }
    }
}
