package com.abhishek.algorithms.davincicode.container;

import java.util.Iterator;

public interface Container<T> extends Iterator<T> {

    boolean add(T t);

    boolean addAll(Container<? extends T> c);

    void clear();

    boolean contains(Object o);

    boolean containsAll(Object o);

    Iterator<T> iterator();

    boolean remove(Object o);

    boolean removeAll(Container<? extends T> c);

    boolean retainAll(Container<?> c);

    int size();

    boolean isEmpty();

    Object[] toArray();

    <T> T[] toArray(T[] t);

}
