package com.vitaliy.turkov.level.editor.storage;


import java.util.List;

public final class StorageFromFile<T> implements Storage<T> {

    private final File file;
    private final Deserializer<String, T> deserializer;
    private final Serializer<T, String> serializer;

    public StorageFromFile(File file,
                           Deserializer<String, T> deserializer,
                           Serializer<T, String> serializer) {
        this.file = file;
        this.deserializer = deserializer;
        this.serializer = serializer;
    }

    @Override
    public List<T> items() {
        return new LevelListFromFile<>(file, deserializer);
    }

    @Override
    public void remove(Integer number) {
        file.deleteLineByNumber(number);
    }

    @Override
    public void update(Integer number, T item) {
        file.replaceLineByNumber(number, serializer.item(item));
    }
}
