package com.myhashmap;

import com.myhashmap.utils.MyHashMap;

public class Main {

    public static void main(String[] args) {

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(3, null);
        myHashMap.put(-4, (long) 4);
        myHashMap.put(5, (long) 5);
        myHashMap.put(4, (long) 38);

        System.out.println("Value for key 4: " + myHashMap.get(4));
        System.out.println("The size of map is: " + myHashMap.size());
    }
}
