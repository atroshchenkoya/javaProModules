package ru.otus.patterns2;

public class ItemsServiceProxy {

    private final ItemService itemService;

    public ItemsServiceProxy(ItemService itemService) {
        this.itemService = itemService;
    }

    public void saveAll() {
        beginTransaction();
        try {
            itemService.saveAll();
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    public void loadAllAndX2Price() {
        beginTransaction();
        try {
            itemService.loadAllAndX2Price();
            commitTransaction();
        } catch (Exception e) {
            rollbackTransaction();
            throw e;
        }
    }

    private void beginTransaction() {
        System.out.println("Transaction started");
    }

    private void commitTransaction() {
        System.out.println("Transaction committed");
    }

    private void rollbackTransaction() {
        System.out.println("Transaction rolled back");
    }
}