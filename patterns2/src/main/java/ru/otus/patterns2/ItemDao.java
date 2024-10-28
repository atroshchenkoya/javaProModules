package ru.otus.patterns2;

public class ItemDao {

    DataSource dataSource;

    public ItemDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(Item item) {
        dataSource.getMap().put(item.getId(), item);
    }
}
