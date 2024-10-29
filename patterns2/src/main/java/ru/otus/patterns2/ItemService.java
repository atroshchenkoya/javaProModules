package ru.otus.patterns2;

import java.util.List;

public class ItemService {

    static ItemDao itemDao = new ItemDao(DataSource.getInstance());

    public void saveAll() {
        for (int i = 0; i < 100; i++) {
            Item item = Item.builder()
                    .name("Item " + i)
                    .price(32.12)
                    .id(i)
                    .build();
            itemDao.save(item);
            System.out.println("Item " + i + " saved");
        }
    }
    public void loadAllAndX2Price() {
        List<Item> list = itemDao.loadAll();
        for (Item item : list) {
            Item itemToSave = Item.builder()
                    .name(item.getName())
                    .price(item.getPrice()*2)
                    .id(item.getId())
                    .build();
            itemDao.save(itemToSave);
            System.out.println("Item " + item.getName() +  " saved with double price: " + itemToSave.getPrice());
        }
    }
}
