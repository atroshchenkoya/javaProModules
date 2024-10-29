package ru.otus.patterns2;


public class Main {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        itemService.saveAll();
        itemService.loadAllAndX2Price();
    }
}