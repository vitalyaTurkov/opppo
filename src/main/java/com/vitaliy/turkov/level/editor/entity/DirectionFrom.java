package com.vitaliy.turkov.level.editor.entity;

public class DirectionFrom {
    private final String value;

    public DirectionFrom(String value) {
        this.value = value;
    }

    public Direction direction() {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        if (Direction.UP.equals(value)) {
            return Direction.UP;
        } else if (Direction.DOWN.equals(value)) {
            return Direction.DOWN;
        } else if (Direction.RIGHT.equals(value)) {
            return Direction.RIGHT;
        } else if (Direction.UP_RIGHT.equals(value)) {
            return Direction.UP_RIGHT;
        } else if (Direction.DOWN_RIGHT.equals(value)) {
            return Direction.DOWN_RIGHT;
        } else if (Direction.LEFT.equals(value)) {
            return Direction.LEFT;
        } else if (Direction.UP_LEFT.equals(value)) {
            return Direction.UP_LEFT;
        } else if (Direction.DOWN_LEFT.equals(value)) {
            return Direction.DOWN_LEFT;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
