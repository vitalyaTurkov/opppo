package com.vitaliy.turkov.level.editor.entity;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    UP("Up"),
    DOWN("Down"),
    RIGHT("Right"),
    UP_RIGHT("UpRight"),
    DOWN_RIGHT("DownRight"),
    LEFT("Left"),
    UP_LEFT("UpLeft"),
    DOWN_LEFT("DownLeft");

    private final String name;

    Direction(String name) {
        this.name = name;
    }

    public Boolean equals(String value) {
        return value.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public static List<Direction> asList() {
        return Arrays.asList(
                UP,
                DOWN,
                RIGHT,
                UP_RIGHT,
                DOWN_RIGHT,
                LEFT,
                UP_LEFT,
                DOWN_LEFT
        );
    }
}
