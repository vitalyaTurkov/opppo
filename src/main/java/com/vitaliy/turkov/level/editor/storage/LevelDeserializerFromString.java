package com.vitaliy.turkov.level.editor.storage;

import com.vitaliy.turkov.level.editor.entity.Direction;
import com.vitaliy.turkov.level.editor.entity.DirectionFrom;
import com.vitaliy.turkov.level.editor.entity.Level;
import com.vitaliy.turkov.level.editor.entity.Step;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public final class LevelDeserializerFromString implements Deserializer<String, Level> {

    @Override
    public Level item(String itemAsString) {
        Scanner scanner = new Scanner(itemAsString);
        Integer height = scanner.nextInt();
        Integer width = scanner.nextInt();
        scanner.useDelimiter(",");
        Integer startPointX = new Integer(scanner.next().replace(" ", ""));
        Integer startPointY = scanner.nextInt();
        List<Step> steps = new ArrayList<>(Collections.emptyList());
        while (scanner.hasNext()) {
            Direction direction = new DirectionFrom(scanner.next().replace("{", "")).direction();
            Integer length = new Integer(scanner.next().replace("}", ""));
            steps.add(
                    new Step(
                            length,
                            direction
                    ));
        }
        return new Level(height, width, startPointX, startPointY, steps);
    }
}
