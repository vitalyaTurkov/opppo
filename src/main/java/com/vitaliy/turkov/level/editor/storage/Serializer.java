package com.vitaliy.turkov.level.editor.storage;

public interface Serializer<FROM, TO> {
    TO item(FROM itemAs);
}
