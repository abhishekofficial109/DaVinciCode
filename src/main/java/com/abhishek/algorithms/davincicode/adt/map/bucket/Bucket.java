package com.abhishek.algorithms.davincicode.adt.map.bucket;

public class Bucket<K, V> {
    private int hash;
    private K key;
    private V value;
    private Bucket<K, V> next;
    private Bucket<K, V> prev;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Bucket<K, V> getNext() {
        return next;
    }

    public void setNext(Bucket<K, V> next) {
        this.next = next;
    }

    public Bucket<K, V> getPrev() {
        return prev;
    }

    public void setPrev(Bucket<K, V> prev) {
        this.prev = prev;
    }
}
