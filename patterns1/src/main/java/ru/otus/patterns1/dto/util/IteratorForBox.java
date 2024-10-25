package ru.otus.patterns1.dto.util;

import ru.otus.patterns1.dto.Box;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorForBox implements Iterator<String> {
    private final List<String> allStrings;
    private int currentIndex = -1;

    public IteratorForBox(Box box) {
        allStrings = new ArrayList<>();
        allStrings.addAll(box.firstList);
        allStrings.addAll(box.secondList);
        allStrings.addAll(box.thirdList);
        allStrings.addAll(box.fourthList);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < allStrings.size() - 1;
    }

    @Override
    public String next() {
        if (!hasNext())
            return null;
        currentIndex++;
        return allStrings.get(currentIndex);
    }
}
