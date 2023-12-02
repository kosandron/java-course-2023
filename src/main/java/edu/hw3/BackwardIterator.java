package edu.hw3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private List<T> collection;
    private int pointer;

    public BackwardIterator(Collection collection) {
        this.collection = new ArrayList<>(collection);
        pointer = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return pointer - 1 > -1;
    }

    @Override
    public T next() {
        return collection.get(pointer--);
    }
}
