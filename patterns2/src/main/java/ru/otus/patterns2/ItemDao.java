package ru.otus.patterns2;

import java.util.List;

public class ItemDao {

    DataSource dataSource;

    public ItemDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Item item) {
        dataSource.getMap().put(item.getId(), item);
    }

    public List<Item> loadAll() {
        return dataSource.getMap().values().stream().toList();
    }
}
