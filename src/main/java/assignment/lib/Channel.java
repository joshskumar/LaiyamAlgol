package assignment.lib;

import java.util.Hashtable;

public class Channel extends Thread{

    private final String sourceProcessName;
    private Event event;
    private final String snapshot = "Taking the snapshot ";
    private Constants globalState;

    public Channel(Event event, String sourceProcessName){
        this.event = event;
        this.sourceProcessName = sourceProcessName;
        globalState = Constants.init();
    }

    public void run (){
        ProcessorState sourceState = globalState.getGlobalstate().get(sourceProcessName);
       if (event.getSnapshot() && (sourceState.getColor() == Color.WHITE) ){
               System.out.println(snapshot);
               globalState.setGlobalstate(sourceProcessName,Color.RED,sourceState.getValue());
       } else {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("the event is from "+sourceProcessName +"to destination " + event.getDestProcess());
           Color color = Color.WHITE;
           if(sourceState.getColor() == Color.RED){
               color = Color.RED;
           }
           ProcessorState destState = globalState.getGlobalstate().get(event.getDestProcess());
            globalState.setGlobalstate(event.getDestProcess(),color,destState.getValue()-event.getAmount());
       }
    }

}
