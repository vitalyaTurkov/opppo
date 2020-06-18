package com.vitaliy.turkov.level.editor.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Step {
    private Integer length;
    private Direction direction;

    public Step(Integer length, Direction direction) {
        this.length = length;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Step{" +
                "length=" + length +
                ", direction=" + direction +
                '}';
    }

    public Integer getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }
}
