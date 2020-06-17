package com.vitaliy.turkov.level.editor;

import com.vitaliy.turkov.level.editor.storage.LevelDeserializerFromString;
import com.vitaliy.turkov.level.editor.storage.LevelFile;
import com.vitaliy.turkov.level.editor.storage.LevelSerializerToString;
import com.vitaliy.turkov.level.editor.storage.StorageFromFile;
import com.vitaliy.turkov.level.editor.ui.MainUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class LevelEditor extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String path = LevelEditor.class.getResource("/levels.db").getPath();
        primaryStage.setTitle("Drawing Operations Test");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setScene(
                new MainUI(
                        new StorageFromFile<>(
                                new LevelFile(
                                       path
                                ),
                                new LevelDeserializerFromString(),
                                new LevelSerializerToString()
                        )
                )
        );
        primaryStage.show();
    }
}
