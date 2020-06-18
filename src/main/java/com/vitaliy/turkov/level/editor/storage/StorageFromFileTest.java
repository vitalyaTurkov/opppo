package com.vitaliy.turkov.level.editor.storage;

import com.vitaliy.turkov.level.editor.entity.Level;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StorageFromFileTest {

    StorageFromFile<Level> storage = new StorageFromFile<>(
            new File.Fake(),
            new LevelDeserializerFromString(),
            new LevelSerializerToString()
    );

    @Test
    void items() {
        for (int i = 0; i < storage.items().size(); i++) {
            assertEquals(storage.items().get(i), File.Fake.defaultList.get(i));
        }
    }

    @Test
    void remove() {
    }

    @Test
    void update() {
    }

    @Test
    void add() {
    }
}