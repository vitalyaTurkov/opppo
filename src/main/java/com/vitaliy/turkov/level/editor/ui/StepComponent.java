package com.vitaliy.turkov.level.editor.ui;

import com.sun.javafx.collections.ObservableListWrapper;
import com.vitaliy.turkov.level.editor.entity.Direction;
import com.vitaliy.turkov.level.editor.entity.Step;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.function.Consumer;

public class StepComponent extends GridPane {
    public StepComponent(Step step,
                         Consumer<Step> onStepChange,
                         Runnable onDelete) {
        setPadding(new Insets(5, 5, 5, 5));
        setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT
                        )
                )
        );
        NumberField stepLength = new NumberField();
        stepLength.setValue(step.getLength());
        ComboBox<Direction> direction = new ComboBox<>();
        Button delete = new Button("Удалить");
        ObservableListWrapper<Direction> directions = new ObservableListWrapper<>(Direction.asList());
        direction.setItems(directions);
        direction.setValue(step.getDirection());
        direction.valueProperty().addListener(event -> {
            step.setDirection(direction.getValue());
            onStepChange.accept(step);
        });
        stepLength.textProperty().addListener(v -> {
            step.setLength(stepLength.getValue());
            onStepChange.accept(step);
        });
        delete.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> onDelete.run());
        add(stepLength, 0, 0);
        add(direction, 0, 1);
        add(delete, 0, 2);
    }
}
