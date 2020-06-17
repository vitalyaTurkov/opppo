package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.storage.Storage;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.util.List;

public class MainUIRoot extends Group {
    private static final Integer COUNT_PER_ROW = 5;

    public MainUIRoot(Storage<Level> storage) {
        GridPane gridPane = new GridPane();
        List<Level> items = storage.items();
        for (int i = 0; i < items.size(); i++) {
            final int iBuf = i;
            LevelComponent level = new LevelComponent(
                    items.get(i),
                    l -> {
                        storage.remove(iBuf);
                    },
                    l -> storage.update(iBuf, l)
            );
            gridPane.add(
                    level,
                    i / COUNT_PER_ROW,
                    i % COUNT_PER_ROW
            );
        }
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setPrefViewportHeight(750);
        scrollPane.setPrefViewportWidth(780);
        getChildren().add(scrollPane);
    }
}
