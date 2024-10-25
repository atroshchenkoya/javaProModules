package ru.otus.patterns1;

import ru.otus.patterns1.dto.Box;
import ru.otus.patterns1.dto.Product;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        Product product = Product.builder()
                .id(UUID.randomUUID())
                .height(2.1)
                .cost(11)
                .title("POP")
                .description("HOP")
                .length(12.2)
                .weight(4.6)
                .cost(0)
                .width(22.12)
                .build();
        System.out.println(product.getWeight());

        Box box = new Box();
        box.firstList = List.of("1", "2", "3", "4", "5");
        box.secondList = List.of("6", "7", "8", "9", "10");
        box.thirdList = List.of("11", "12", "13", "14", "15");
        box.fourthList = List.of("16", "17", "18", "19");
        var iterator = box.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}