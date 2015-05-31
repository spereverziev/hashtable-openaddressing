package com.spereverziev;

/**
 * Created by spereverziev on 29.05.15.
 */
public class HashMapOpenAddressing implements SimpleMap {

    private static final int HASHTABLE_SIZE = 7;

    private HashTableEntry[] table;
    private int numberOfEntries;

    public HashMapOpenAddressing() {
        table = new HashTableEntry[HASHTABLE_SIZE];
        numberOfEntries = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    private int hash(int k, int probe) {
        return (simpleHash(k) + probe * doubleHashing(k)) % HASHTABLE_SIZE;
    }

    private int simpleHash(int k) {
        return k % HASHTABLE_SIZE;
    }

    private int doubleHashing(int k) {
        return 1 + (k % (HASHTABLE_SIZE -1));
    }

    @Override
    public Long get(int key) {
        int probe = 0;
        while (probe <= HASHTABLE_SIZE) {
            int index = hash(key, probe);
            HashTableEntry tableEntry = table[index];
            if (tableEntry != null && tableEntry.getKey() == key) {
                return tableEntry.getValue();
            } else {
                probe++;
            }
        }

        return null;
    }

    @Override
    public void put(int key, long value) {
        int probe = 0;
        while(probe <= HASHTABLE_SIZE) {
            int index = hash(key, probe);
            if (table[index] == null) {
                table[index] = new HashTableEntry(key, value);
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
