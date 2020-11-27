package com.abhishek.algorithms.davincicode.adt.map;

import com.abhishek.algorithms.davincicode.adt.map.bucket.Bucket;

import java.util.HashSet;
import java.util.Set;

public class HashBasedMap<K, V> {
    private Bucket<K, V>[] buckets;
    private int capacity;
    private float loadFactor;
    private int size;
    private float threshold;

    public HashBasedMap() {
        this.capacity = 16;
        this.loadFactor = 0.75f;
        this.size = 0;
        this.threshold = this.capacity * this.loadFactor;
        this.buckets = new Bucket[this.capacity];
    }

    public HashBasedMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = (loadFactor > 1.00) ? 0.75f : loadFactor;
        this.size = 0;
        this.threshold = this.capacity * this.loadFactor;
        this.buckets = new Bucket[this.capacity];
    }

    public void put(K key, V value) {
        if (isReHashingRequired())
            reHashBuckets();
        int index = index(key);
        Bucket<K, V> temp = this.buckets[index];
        Bucket<K, V> newBucket = getNewBucket(key, value);
        if (temp == null) {
            buckets[index] = newBucket;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            newBucket.setPrev(temp);
            temp.setNext(newBucket);
        }
        this.size++;
    }

    public V get(K key){
        int index=index(key);
        Bucket<K, V> temp = this.buckets[index];
        if(temp==null)
            return null;
        while(temp!=null){
            if(temp.getKey().equals(key))
                return temp.getValue();
            temp=temp.getNext();
        }
        return null;
    }

    public Set<K> keySet(){
        Set<K> keySet=new HashSet<K>();
        for(int i=0;i<this.capacity;i++){
            Bucket<K,V> bucket=this.buckets[i];
            while(bucket!=null){
                keySet.add(bucket.getKey());
                bucket=bucket.getNext();
            }
        }
        return keySet;
    }

    private Bucket<K, V> getNewBucket(K key, V value) {
        Bucket<K, V> newBucket = new Bucket<K, V>();
        newBucket.setNext(null);
        newBucket.setPrev(null);
        newBucket.setHash(key.hashCode());
        newBucket.setKey(key);
        newBucket.setValue(value);
        return newBucket;
    }

    private int index(K key) {
        return key.hashCode() & (this.capacity - 1);
    }

    private boolean isReHashingRequired() {
        return this.threshold == this.size;
    }

    private void reHashBuckets() {
        int newCapacity = this.capacity * 2;
        Bucket<K, V>[] newBuckets = new Bucket[newCapacity];
        for (int i = 0; i < this.capacity; i++) {
            Bucket<K, V> bucket = this.buckets[i];
            while (bucket != null) {
                add(newBuckets, bucket);
                bucket = bucket.getNext();
            }
        }
        this.capacity = newCapacity;
        this.threshold = this.capacity * this.loadFactor;
        this.buckets = newBuckets;
    }

    private void add(Bucket<K, V>[] buckets, Bucket<K, V> bucket) {
        int n = buckets.length;
        int index = bucket.hashCode() & (n - 1);
        Bucket<K, V> temp = buckets[index];
        if (temp == null) {
            bucket.setNext(null);
            bucket.setPrev(null);
            buckets[index] = bucket;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            bucket.setPrev(temp);
            temp.setNext(bucket);
        }
    }
    public static void main(String args[]){
        HashBasedMap<Integer,Integer> map=new HashBasedMap<>();
        for(int i=0;i<24;i++){
            map.put(i,1);
        }
        System.out.println(map.get(18));
    }
}
