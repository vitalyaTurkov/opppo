package com.vitaliy.turkov.level.editor.storage;

import com.vitaliy.turkov.level.editor.entity.Level;

public final class LevelSerializerToString implements Serializer<Level, String> {
    @Override
    public String item(Level itemAs) {
        return itemAs.toString();
    }
}
