package com.vitaliy.turkov.level.editor.storage;

import java.util.ArrayList;
import java.util.Scanner;

public final class LevelListFromFile<T> extends ArrayList<T> {
    public LevelListFromFile(File file, Deserializer<String, T> deserializer) {
        super();
        Scanner scanner = file.scanner();
        while (scanner.hasNextLine()) {
            add(deserializer.item(scanner.nextLine()));
        }
    }
}
