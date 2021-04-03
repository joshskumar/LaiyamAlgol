package assignment.lib.processor;

import assignment.lib.event.Channel;
import assignment.lib.event.Event;

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



    public void setEventList(Event event[]){
        this.event = event;
    }


    public void run(){
        Event[] events  = this.getEventList();
        Channel[] channels = new Channel[events.length];
        for(int i=0;i<events.length;i++){
            channels[i]= new Channel(events[i],this.name);
        }
        for (Channel channel:channels){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            channel.start();
        }
    }
}
