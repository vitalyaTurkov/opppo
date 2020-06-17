package com.vitaliy.turkov.level.editor.storage;

import java.util.Scanner;

public interface File {
    Scanner scanner();
    void replaceLineByNumber(Integer lineNumber, String value);
    void deleteLineByNumber(Integer lineNumber);
}
