package com.vitaliy.turkov.level.editor.ui;

import javafx.scene.control.TextField;


public class NumberField extends TextField {
    public NumberField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                setText(oldValue);
            }
        });
    }

    public void setValue(Integer value) {
        setText(value.toString());
    }

    public Integer getValue() {
        if (getText().length() == 0) {
            return 0;
        }
        try {
            return new Integer(getText());
        } catch (NumberFormatException exception) {
            return 0;
        }
    }
}
