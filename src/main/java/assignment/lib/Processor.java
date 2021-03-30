package assignment.lib;

public class Processor {

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

    public String getName() {
        return name;
    }
}
