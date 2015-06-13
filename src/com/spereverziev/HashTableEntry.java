package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public class HashTableEntry<K,V> {
    private K key;
    private V value;

    public HashTableEntry(K key, V value) {
        this.key = key;
        this.value = value;
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

}
