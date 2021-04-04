package assignment.utils;

import java.util.HashMap;
import java.util.Set;

/**
 * This code is optional code to reset the Processors to take snap shots again if the
 */
public class ResetSnapshot {
    private HashMap<Color,Boolean> colorBoolean = new HashMap<Color, Boolean>();
    private  static ResetSnapshot reset = null;

    public static ResetSnapshot init(){
        if (reset == null){
           reset = new ResetSnapshot();
           reset.colorBoolean.put(Color.WHITE,false);
           reset.colorBoolean.put(Color.RED,true);
        }
        return reset;
    }

    public synchronized void reset(){
        Constants globalState = Constants.init();
        boolean flag = true;
        for ( String key : globalState.getGlobalstate().keySet()) {
            ProcessorState state = globalState.getGlobalstate().get(key);
            flag = flag && colorBoolean.get(state.getColor());
        }
        if(flag){
            for ( String key : globalState.getGlobalstate().keySet()){
                ProcessorState state = globalState.getGlobalstate().get(key);
                int amount=state.getValue();
                globalState.setGlobalstate(key,Color.WHITE,amount);
            }
        }
    }

}
