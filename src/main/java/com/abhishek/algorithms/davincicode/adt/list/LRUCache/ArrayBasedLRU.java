package com.abhishek.algorithms.davincicode.adt.list.LRUCache;

public class ArrayBasedLRU<T> implements LRUCache<T> {

    private Object[] cache;
    private int size;
    private int capacity;

    public ArrayBasedLRU() {
        super();
        this.capacity = 10;
        this.cache = new Object[this.capacity];
        this.size = 0;
    }

    public ArrayBasedLRU(int capacity) {
        super();
        this.capacity = capacity;
        this.cache = new Object[this.capacity];
        this.size = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    private int find(T key) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.cache[i] == key) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(T key) {
        int index = find(key);
        if (index == -1) {
            Object[] temp = new Object[this.capacity];
            temp[0] = key;
            for (int i = 0; i < this.capacity - 1; i++) {
                temp[i + 1] = this.cache[i];
            }
            this.cache = temp;
        } else {
            Object[] temp = new Object[this.capacity];
            temp[0] = key;
            for (int i = 0; i < this.capacity - 1; i++) {
                if (index == i)
                    continue;
                temp[i + 1] = this.cache[i];
            }
            this.cache = temp;
        }
        return this.cache[0];
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

}
