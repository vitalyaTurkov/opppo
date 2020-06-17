package com.vitaliy.turkov.level.editor.entity;

public class Step {
    private final Integer length;
    private final Direction direction;

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
