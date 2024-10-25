package ru.otus.patterns1.dto;

import ru.otus.patterns1.dto.util.IteratorForBox;

import java.util.List;

public class Box {
    public List<String> firstList;
    public List<String> secondList;
    public List<String> thirdList;
    public List<String> fourthList;

    public IteratorForBox getIterator() {
        return new IteratorForBox(this);
    }
}
