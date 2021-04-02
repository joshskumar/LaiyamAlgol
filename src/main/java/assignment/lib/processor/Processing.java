package assignment.lib.processor;

import assignment.lib.event.Channel;
import assignment.lib.event.Event;

public class Processing extends Thread {

    private Processor processor;

    public Processing(Processor processor){
        this.processor = processor;
    }

    public void run(){
        Event[] events  = processor.getEventList();
        Channel[] channels = new Channel[events.length];
        for(int i=0;i<events.length;i++){
             channels[i]= new Channel(events[i],processor.getName());
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