package com.vitaliy.turkov.level.editor.storage;


public interface Deserializer<FROM, TO> {
    TO item(FROM itemAs);
}
