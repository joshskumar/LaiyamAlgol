package assignment.lib;

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
            channel.start();
        }
    }
}
