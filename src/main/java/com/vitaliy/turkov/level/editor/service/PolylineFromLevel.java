package com.vitaliy.turkov.level.editor.service;

import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;
import com.vitaliy.turkov.level.editor.ui.Polyline;


public final class PolylineFromLevel {
    private final Level level;
    private static final Integer RATIO = 1;
    private static final Integer STEP_LENGTH = 15 * RATIO;

    public PolylineFromLevel(Level level) {
        this.level = level;
    }

    public Polyline polyline() {
        Polyline result = new Polyline();
        int previousX = level.getStartPointX() * STEP_LENGTH;
        int previousY = level.getStartPointY() * STEP_LENGTH;
        result.addPoint(previousX, previousY);
        for (Step step : level.getSteps()) {
            switch (step.getDirection()) {
                case UP:
                    previousY = previousY - STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN:
                    previousY = previousY + STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case RIGHT:
                    previousX = previousX + STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case UP_RIGHT:
                    previousX = previousX + STEP_LENGTH * step.getLength();
                    previousY = previousY - STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN_RIGHT:
                    previousX = previousX + STEP_LENGTH * step.getLength();
                    previousY = previousY + STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case LEFT:
                    previousX = previousX - STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case UP_LEFT:
                    previousX = previousX - STEP_LENGTH * step.getLength();
                    previousY = previousY - STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
                case DOWN_LEFT:
                    previousX = previousX - STEP_LENGTH * step.getLength();
                    previousY = previousY + STEP_LENGTH * step.getLength();
                    result.addPoint(previousX, previousY);
                    break;
            }
        }
        return result;
    }
}
