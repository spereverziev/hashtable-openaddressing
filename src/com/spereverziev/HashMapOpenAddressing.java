package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public class HashMapOpenAddressing<K,V>  implements SimpleMap<K,V>{

    private static final int HASHTABLE_SIZE = 7;

    private HashTableEntry[] table;
    private int numberOfEntries;

    public HashMapOpenAddressing() {
        table = new HashTableEntry[HASHTABLE_SIZE];
        numberOfEntries = 0;
    }

    private int hash(K k, int probe) {
        return Math.abs(simpleHash(k.hashCode()) + probe * doubleHashing(k)) % HASHTABLE_SIZE;
    }

    private int simpleHash(int k) {
        return k % HASHTABLE_SIZE;
    }

    private int doubleHashing(K k) {
        return 1 + (k.hashCode() % (HASHTABLE_SIZE -1));
    }

    @Override
    public V get(K key) {
        int probe = 0;
        while (probe <= HASHTABLE_SIZE) {
            int index = hash(key, probe);
            HashTableEntry tableEntry = table[index];
            if (tableEntry != null && tableEntry.getKey() == key) {
                return (V)tableEntry.getValue();
            } else {
                probe++;
            }
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
        int probe = 0;
        while(probe <= HASHTABLE_SIZE) {
            int index = hash(key, probe);
            if (table[index] == null) {
                table[index] = new HashTableEntry<K, V>(key, value);
                numberOfEntries++;
                return;
            } else {
                probe++;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Hashtable is full");
    }


    @Override
    public int size() {
        return numberOfEntries;
    }
}
