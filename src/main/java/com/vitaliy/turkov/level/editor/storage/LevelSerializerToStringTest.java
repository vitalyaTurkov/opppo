package com.vitaliy.turkov.level.editor.storage;

import com.vitaliy.turkov.level.editor.entity.Direction;
import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LevelSerializerToStringTest {

    @Test
    void item() {
        Level level = new Level(
                1,
                2,
                3,
                4,
                Arrays.asList(new Step(3, Direction.DOWN))
        );
        String itemAsString = new LevelSerializerToString().item(level);
        assertEquals(level.toString(), itemAsString);
    }
}