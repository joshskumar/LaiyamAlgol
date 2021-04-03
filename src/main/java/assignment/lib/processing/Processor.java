package assignment.lib.processing;


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
//        Event[] events  = this.getEventList();
//        Channel[] channels = new Channel[events.length];
//        for(int i=0;i<events.length;i++){
//            try {
//                Thread.sleep(event[i].getLaunchDelay());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            channels[i]= new Channel(events[i],this.name);
//        }
//        for (Channel channel:channels){
//            channel.start();
//        }
        for (Event event : this.getEventList()){
            try {
                Thread.sleep(event.getLaunchDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.start();
        }
    }
}
