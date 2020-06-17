package com.vitaliy.turkov.level.editor.ui;


import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.service.PolylineFromLevel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LevelCanvas extends Canvas {
    private final Level level;

    public LevelCanvas(Level level) {
        super(300, 250);
        this.level = level;
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        Polyline polyline = new PolylineFromLevel(level).polyline();
        gc.strokePolygon(polyline.getX(), polyline.getY(), polyline.getPointCount());
    }
}
