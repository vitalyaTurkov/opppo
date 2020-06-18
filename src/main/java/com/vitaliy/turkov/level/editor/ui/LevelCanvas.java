package com.vitaliy.turkov.level.editor.ui;


import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.service.PolylineFromLevel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class LevelCanvas extends Canvas {
    public LevelCanvas(Level level,
                       Integer width,
                       Integer height,
                       Integer iconSize) {
        super(level.getWidth() * 25, level.getHeight() * 25);
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        Polyline polyline = new PolylineFromLevel(level, iconSize).polyline();
        for (int i = 0; i < polyline.getPointCount() - 1; i++) {
            gc.strokeLine(
                    polyline.getX()[i],
                    polyline.getY()[i],
                    polyline.getX()[i + 1],
                    polyline.getY()[i + 1]
            );
        }
        gc.fillOval(polyline.getX()[0], polyline.getY()[0], 8, 8);
    }
}
