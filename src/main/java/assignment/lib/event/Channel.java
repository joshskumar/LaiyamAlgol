package assignment.lib.event;

import assignment.lib.processor.ProcessorState;
import assignment.utils.Color;
import assignment.utils.Constants;

public class Channel extends Thread{

    private final String sourceProcessName;
    private Event event;
    private final String snapshot = "THIS IS THE SNAPSHOT OF THE PROCESSOR ";
    private Constants globalState;

    public Channel(Event event, String sourceProcessName){
        this.event = event;
        this.sourceProcessName = sourceProcessName;
        globalState = Constants.init();
    }

    public void run (){

        ProcessorState sourceState = globalState.getGlobalstate().get(sourceProcessName);
       if (event.getSnapshot() && (sourceState.getColor() == Color.WHITE) ){
               System.out.println(snapshot + " of the processor "+ sourceProcessName);
               globalState.setGlobalstate(sourceProcessName,Color.RED,sourceState.getValue());
           globalState.displayGlobalState(sourceProcessName);
       } else {
           if(!sourceProcessName.equalsIgnoreCase(event.getDestProcess())) {
               globalState.setGlobalstate(sourceProcessName, sourceState.getColor(), sourceState.getValue() - event.getAmount());
           }
           globalState.displayGlobalState(sourceProcessName);
           try {
               Thread.sleep(event.getTimeTaken());
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("the event has reached the destination process : " + event.getDestProcess());

           Color sorcestateColor = sourceState.getColor();


           ProcessorState destState = globalState.getGlobalstate().get(event.getDestProcess());
           Color deststateColor = destState.getColor();

           Color color = Color.WHITE;
           if(sorcestateColor == Color.RED && deststateColor == Color.WHITE){
               color = Color.RED;
               System.out.println(snapshot + " of the processor "+ event.getDestProcess());
           }
           else if (sorcestateColor == Color.RED || deststateColor == Color.RED){
               color = Color.RED;
           }

           globalState.setGlobalstate(event.getDestProcess(),color,destState.getValue() + event.getAmount());
           globalState.displayGlobalState(event.getDestProcess());
       }

    }

}
