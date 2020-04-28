package com.vitaliy.turkov.level.editor.db;

public class LevelFile implements ReadableLevelFile {
    private final String path;

    public LevelFile(String path) {
        this.path = path;
    }
}
