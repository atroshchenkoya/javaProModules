package ru.otus.patterns2;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class Item {
    private final long id;
    private final String name;
    private final double price;
}
