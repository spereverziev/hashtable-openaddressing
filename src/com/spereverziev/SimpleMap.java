package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public interface SimpleMap<K,V> {
    V get(K key);
    void put(K key,V value);
    int size();
}
