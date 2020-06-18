package com.vitaliy.turkov.level.editor.storage;

import java.util.List;

public interface Storage<T> {
    List<T> items();
    void remove(Integer number);
    void update(Integer number, T item);
    void add(T level);
}
