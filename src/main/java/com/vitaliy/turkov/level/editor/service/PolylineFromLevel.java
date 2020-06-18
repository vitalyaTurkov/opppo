package com.vitaliy.turkov.level.editor.service;

import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;
import com.vitaliy.turkov.level.editor.ui.Polyline;


public final class PolylineFromLevel {
    private final Level level;
    private final Integer iconSize;

    public PolylineFromLevel(Level level, Integer iconSize) {
        this.level = level;
        this.iconSize = iconSize;
    }

    public Polyline polyline() {
        Polyline result = new Polyline();
        int previousX = level.getStartPointX() * iconSize;
        int previousY = level.getStartPointY() * iconSize;
        result.addPoint(previousX, previousY);
        for (Step step : level.getSteps()) {
            switch (step.getDirection()) {
                case UP:
                    previousY = previousY - iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN:
                    previousY = previousY + iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case RIGHT:
                    previousX = previousX + iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case UP_RIGHT:
                    previousX = previousX + iconSize * step.getLength();
                    previousY = previousY - iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN_RIGHT:
                    previousX = previousX + iconSize * step.getLength();
                    previousY = previousY + iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case LEFT:
                    previousX = previousX - iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case UP_LEFT:
                    previousX = previousX - iconSize * step.getLength();
                    previousY = previousY - iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN_LEFT:
                    previousX = previousX - iconSize * step.getLength();
                    previousY = previousY + iconSize * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
            }
        }
        return result;
    }
}
