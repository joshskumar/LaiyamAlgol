package assignment.utils;

import assignment.utils.Color;

/**
 * This Class is for maintaining the Processor state and various points
 */

public class ProcessorState {
    private int value;
    private Color color;


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
