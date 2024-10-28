package ru.otus.patterns2;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataSource {
    private static DataSource instance;
    private final Map<Long, Item> map = new HashMap<>();

    private DataSource() {}

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
            return instance;
        }
        return instance;
    }
}