package com.vitaliy.turkov.level.editor.storage;

import com.vitaliy.turkov.level.editor.entity.Direction;
import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;

import java.util.*;
import java.util.stream.Collectors;

public interface File {
    Scanner scanner();
    void replaceLineByNumber(Integer lineNumber, String value);
    void deleteLineByNumber(Integer lineNumber);
    void append(String item);

    class Fake implements File {
        public static final List<Level> defaultList = new ArrayList<>();

        public Fake() {
            defaultList.add(new Level(
                    2,
                    2,
                    2,
                    2,
                    Collections.singletonList(new Step(2, Direction.DOWN))));
            defaultList.add(new Level(
                    2,
                    2,
                    2,
                    2,
                    Collections.singletonList(new Step(2, Direction.DOWN))));
        }

        @Override
        public Scanner scanner() {
            String asStr = defaultList.stream()
                    .map(Level::toString)
                    .collect(Collectors.joining());
            return new Scanner(asStr);
        }

        @Override
        public void replaceLineByNumber(Integer lineNumber, String value) {}

        @Override
        public void deleteLineByNumber(Integer lineNumber) {}

        @Override
        public void append(String item) {}
    }
}
