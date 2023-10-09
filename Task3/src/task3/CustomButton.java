package task3;

import javafx.scene.control.Button;

public class CustomButton extends Button {
    // Constructor for creating a custom button with a given label, width, and height
    public CustomButton(String label, double w, double h) {
        // Call the superclass constructor to create a button with the given label
        super(label);
         // Set the width and height of the button to the given values
        this.setMinWidth(w);
        this.setMinHeight(h);
        this.setMaxWidth(w);
        this.setMaxHeight(h);
        this.setPrefWidth(w);
        this.setPrefHeight(h);
    }
}
