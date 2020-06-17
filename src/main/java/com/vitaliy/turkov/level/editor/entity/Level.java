package com.vitaliy.turkov.level.editor.entity;

import java.util.List;
import java.util.stream.Collectors;

public final class Level {
    private final Integer height;
    private final Integer width;
    private final Integer startPointX;
    private final Integer startPointY;
    private final List<Step> steps;

    public Level(Integer height, Integer width, Integer startPointX, Integer startPointY, List<Step> steps) {
        this.height = height;
        this.width = width;
        this.startPointX = startPointX;
        this.startPointY = startPointY;
        this.steps = steps;
    }

    @Override
    public String toString() {
        String stepsString = steps.stream()
                .map(step -> "{" + step.getDirection().toString() + "," + step.getLength().toString() + "}")
                .collect(Collectors.joining(","));
        return height + " " + width + " " + startPointX + "," + startPointY + "," + stepsString + "\n";
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getStartPointX() {
        return startPointX;
    }

    public Integer getStartPointY() {
        return startPointY;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
