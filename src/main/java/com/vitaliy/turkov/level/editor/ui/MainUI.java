package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.storage.Storage;
import javafx.scene.Group;

public final class MainUI extends Group {
    private final Storage<Level> storage;

    public MainUI(Storage<Level> storage) {
        this.storage = storage;
        reload();
    }

    void reload() {
        getChildren().removeAll();
        getChildren().add(
                new MainUIRoot(
                        storage.items(),
                        (levelNumber, level) -> {
                            storage.update(levelNumber, level);
                            reload();
                        },
                        levelNumber -> {
                            storage.remove(levelNumber);
                            reload();
                        },
                        level -> {
                            storage.add(level);
                            reload();
                        }
                )
        );
    }
}
