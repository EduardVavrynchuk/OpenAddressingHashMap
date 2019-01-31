package com.myhashmap;

import com.myhashmap.utils.MyHashMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MyHashMapTest {

    @Test
    public void readWriteSimpleValue() {
        MyHashMap map = new MyHashMap();
        map.put(1, (long) 4);
        map.put(2, (long) 8);
        map.put(3, (long) 4);
        map.put(4, (long) 8);
        assertEquals(4, map.size());
        assertEquals(4, map.get(1).intValue());
        assertEquals(8, map.get(2).intValue());
    }

    @Test
    public void getSomethingThatIsntThere() {
        MyHashMap map = new MyHashMap();
        assertNull(map.get(42));
    }

    @Test
    public void overWriteValue() {
        MyHashMap map = new MyHashMap();
        map.put(42, (long) 1);
        assertEquals(1, map.get(42).intValue());
        map.put(42, (long) 5);
        assertEquals(5, map.get(42).intValue());
    }

}
