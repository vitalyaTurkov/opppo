package com.vitaliy.turkov.level.editor.ui;

import com.vitaliy.turkov.level.editor.entity.Direction;
import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.function.Consumer;

public final class EditLevelComponent extends Stage {
    private final Level level;
    private final Consumer<Level> onSave;
    private LevelCanvas image;

    public EditLevelComponent(Level level, Consumer<Level> onSave) {
        this.level = level;
        this.onSave = onSave;
    }

    @Override
    public void showAndWait() {
        initModality(Modality.APPLICATION_MODAL);
        reload();
        super.showAndWait();
    }

    void reload() {
        Group root = new Group();
        GridPane gridPane = new GridPane();
        reloadCanvas(gridPane);
        GridPane levelItems = new GridPane();
        gridPane.add(levelItems, 2, 1);
        for (int i = 0; i < level.getSteps().size(); i++) {
            final int idx = i;
            levelItems.add(new StepComponent(
                    level.getSteps().get(i),
                    step -> {
                        level.getSteps().set(idx, step);
                        reloadCanvas(gridPane);
                    },
                    () -> {
                        level.getSteps().remove(idx);
                        reload();
                    }
            ), 1, i);
        }
        Button saveBtn = new Button("Сохранить");
        saveBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            onSave.accept(level);
            close();
        });
        Button addStepBtn = new Button("Добавить точку");
        addStepBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            level.getSteps().add(new Step(1, Direction.DOWN));
            reload();
        });
        GridPane buttons = new GridPane();
        buttons.add(saveBtn, 0, 0);
        buttons.add(addStepBtn, 1, 0);
        gridPane.add(buttons, 1, 0);
        ScrollPane scrollPane = new ScrollPane(gridPane);
        scrollPane.setPrefViewportHeight(400);
        root.getChildren().add(scrollPane);
        setScene(new Scene(root));
    }

    public void reloadCanvas(GridPane gridPane) {
        if (image != null) {
            gridPane.getChildren().remove(image);
        }
        image = new LevelCanvas(level, 600, 600, 15);
        GridPane.setValignment(image, VPos.TOP);
        gridPane.add(image, 1, 1);
    }
}
