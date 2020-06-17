package com.vitaliy.turkov.level.editor.storage;


import lombok.SneakyThrows;

import java.io.FileWriter;
import java.util.Scanner;

public final class LevelFile implements File {

    private final String path;

    public LevelFile(String path) {
        this.path = path;
    }

    @SneakyThrows
    @Override
    public Scanner scanner() {
        return new Scanner(new java.io.File(path));
    }

    @SneakyThrows
    @Override
    public void replaceLineByNumber(Integer lineNumber, String value) {
        StringBuilder content = new StringBuilder();
        Scanner scanner = scanner();
        for (int i = 0; scanner.hasNextLine(); i++) {
            if (i == lineNumber) {
                content.append(value);
                scanner.nextLine();
            } else {
                content.append(scanner.nextLine());
            }
        }
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(content.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    @SneakyThrows
    @Override
    public void deleteLineByNumber(Integer lineNumber) {
        StringBuilder content = new StringBuilder();
        Scanner scanner = scanner();
        for (int i = 0; scanner.hasNextLine(); i++) {
            if (i == lineNumber) {
                scanner.nextLine();
            } else {
                content.append(scanner.nextLine());
            }
        }
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(content.toString());
        fileWriter.flush();
        fileWriter.close();
    }
}
