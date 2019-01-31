package com.myhashmap.utils;

public class MyHashMap {
    private static final int DEFAULT_BUCKET_COUNT = 5;

    private int size = 0;
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public MyHashMap(int capacity) {
        buckets = new Entry[capacity];
    }

    public int size() {
        return this.size;
    }

    public Long get(Integer key) {
        int i = findSlot(key);
        if (buckets[i] != null) {
            return buckets[i].getValue();
        } else {
            return null;
        }
    }

    public void put(Integer key, Long value) {
        int i = findSlot(key);
        if (buckets[i] != null) {
            buckets[i].setValue(value);
            return;
        }
        // tables based on open addressing scheme require load factor not to exceed 0.7 to be efficient
        if (((double) size / (double) buckets.length) >= 0.7) {
            resizeTableToTwiceAsLarge();
            i = findSlot(key);
        }
        buckets[i] = new Entry(key, value);
        ++size;
    }

    private int hash(Integer key) {
        return (key & 0x7fffffff) % buckets.length;
    }

    private int findSlot(Integer key) {
        int i = hash(key);

        while ((buckets[i] != null) && !key.equals(buckets[i].getKey())) {
            i = (i + 1) % buckets.length;
        }

        return i;
    }

    private void resizeTableToTwiceAsLarge() {
        Entry[] temp = buckets;

        buckets = new Entry[buckets.length * 2];
        size = 0;

        for (Entry entry : temp) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public class Entry {

        private final Integer key;
        private Long value;

        Entry(Integer key, Long value) {
            this.key = key;
            this.setValue(value);
        }

        Integer getKey() {
            return key;
        }

        void setValue(Long value) {
            this.value = value;
        }

        Long getValue() {
            return value;
        }

    }

}
