package com.vitaliy.turkov.level.editor.entity;

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
}
