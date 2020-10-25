package com.abhishek.algorithms.davincicode.adt.list.linkedlist;

import com.abhishek.algorithms.davincicode.container.Container;

public interface List<T> extends Container<T> {

  boolean addFirst(T t);

  boolean addLast(T t);

  boolean remove(int index);

  boolean removeFirst();

  boolean removeLast();

  boolean search(Object o);

  T get(int index);

  T set(int index, T t);

  List<T> subList(int fromIndex, int endIndex);
}
