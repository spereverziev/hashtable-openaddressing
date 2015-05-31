package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public interface SimpleMap {
    Long get(int key);
    void put(int key,long value);
    int size();
}
