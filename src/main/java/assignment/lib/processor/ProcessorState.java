package assignment.lib.processor;

import assignment.utils.Color;

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