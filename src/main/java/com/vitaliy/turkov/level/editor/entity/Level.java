package com.vitaliy.turkov.level.editor.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public final class Level {
    private Integer height;
    private Integer width;
    private Integer startPointX;
    private Integer startPointY;
    private List<Step> steps;

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
}
