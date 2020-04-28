package com.vitaliy.turkov.level.editor;

import java.io.FileInputStream;
import java.io.IOException;

public class LevelEditor {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Username\\Desktop\\test.txt");

        int i;

        while ((i = fileInputStream.read()) != -1) {

            System.out.print((char) i);
        }
    }
}
