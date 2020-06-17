package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Level;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class LevelComponent extends Group {
    public LevelComponent(Level level, Consumer<Level> onDelete, Consumer<Level> onEdit) {
        GridPane gridPane = new GridPane();
        Button deleteButton = new Button("Удалить");
        Button editButton = new Button("Редактировать");
        deleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            onDelete.accept(level);
        });
        editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            onEdit.accept(level);
        });
        gridPane.add(deleteButton, 0, 0);
        gridPane.add(editButton, 0, 1);
        gridPane.add(new LevelCanvas(level), 0, 2);
        getChildren().add(gridPane);
    }
}
