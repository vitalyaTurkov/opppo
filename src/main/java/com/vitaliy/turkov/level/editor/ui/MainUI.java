package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.storage.Storage;
import javafx.scene.Scene;

public class MainUI extends Scene {
    public MainUI(Storage<Level> storage) {
        super(new MainUIRoot(storage));
    }
}
