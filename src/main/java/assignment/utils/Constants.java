package assignment.utils;

import assignment.lib.processor.ProcessorState;

import java.util.Hashtable;

public class Constants {
    private  Hashtable<String, ProcessorState> globalstate;

    private static Constants constant = null;

    private Constants (){
        globalstate = new Hashtable<String, ProcessorState>();
    }


    public synchronized  static Constants init() {
        if (constant == null){
            constant = new Constants();
        }
        return constant;
    }


    public synchronized  void  setGlobalstate(String processor, Color color, int value) {
        ProcessorState state = new ProcessorState();
        state.setValue(value);
        state.setColor(color);
        globalstate.put(processor,state);
    }

    public synchronized  Hashtable<String, ProcessorState> getGlobalstate(){
        return this.globalstate;
    }

    public synchronized  void displayGlobalState(String stateKey){
      //  for (String stateKey : globalstate.keySet()){
            ProcessorState currentState = globalstate.get(stateKey);
            System.out.println("Processor : " +stateKey+ "\nCurrent color : "+ currentState.getColor()+"\nCurrent amount : "+ currentState.getValue());
     //   }
    }
}
