package ru.otus.patterns2;

public class ItemService {
    public void saveAll() {
        for (int i = 0; i < 100; i++) {
            Item item = Item.builder()
                    .name("Item " + i)
                    .price(32.12)
                    .id(i)
                    .build();
            ItemDao itemDao = new ItemDao(DataSource.getInstance());
            itemDao.save(item);
            System.out.println("Item " + i + " saved");
        }
    }
}
