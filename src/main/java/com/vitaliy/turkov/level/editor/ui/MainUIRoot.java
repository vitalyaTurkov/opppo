package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Level;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class MainUIRoot extends Group {
    private static final Integer COUNT_PER_ROW = 5;

    public MainUIRoot(List<Level> items,
                      BiConsumer<Integer, Level> onEdit,
                      Consumer<Integer> onRemove,
                      Consumer<Level> onAdd) {
        GridPane gridPane = new GridPane();
        Button addButton = new Button("Создать");
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            new EditLevelComponent(
                    new Level(10, 10, 1, 1, new ArrayList<>()),
                    onAdd
            ).showAndWait();
        });
        gridPane.add(addButton, 0, 0);
        for (int i = 1; i < items.size(); i++) {
            final int iBuf = i;
            LevelComponent levelComponent = new LevelComponent(
                    items.get(i),
                    l -> onRemove.accept(iBuf),
                    l -> {
                        new EditLevelComponent(
                                l,
                                level -> onEdit.accept(iBuf, level)
                        ).showAndWait();
                    }
            );
            gridPane.add(
                    levelComponent,
                    i / COUNT_PER_ROW,
                    i % COUNT_PER_ROW
            );
            GridPane.setValignment(levelComponent, VPos.TOP);
        }
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setPrefViewportHeight(750);
        scrollPane.setPrefViewportWidth(780);
        getChildren().add(scrollPane);
    }
}
