package com.abhishek.algorithms.davincicode.adt.list.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

public class HashBasedLRU<T> implements LRUCache<T> {

  private HashMap<T, Object> hash;
  private LinkedList<Object> list;
  private int capacity;

  public HashBasedLRU() {
    super();
    this.capacity = 10;
    this.hash = new HashMap<T, Object>();
    this.list = new LinkedList<Object>();
  }

  public HashBasedLRU(int capacity) {
    super();
    this.capacity = capacity;
    this.hash = new HashMap<T, Object>();
    this.list = new LinkedList<Object>();
  }

  public static void main(String[] args) {

  }

  @Override
  public Object get(T key) {
    if (this.hash.containsKey(key)) {
      Object obj = hash.get(key);
      list.remove(key);
      list.addFirst(obj);
      return obj;
    } else {
      if (this.list.size() == this.capacity) {
        Object obj = this.list.removeLast();
        hash.remove(obj);
        hash.put(key, key);
        list.addFirst(key);
        return key;
      } else {
        this.hash.put(key, key);
        this.list.addFirst(key);
        return key;
      }
    }
  }

  @Override
  public int capacity() {
    return this.capacity;
  }

}
