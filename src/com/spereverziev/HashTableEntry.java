package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public class HashTableEntry {
    private int key;
    private Long value;

    public HashTableEntry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

}
