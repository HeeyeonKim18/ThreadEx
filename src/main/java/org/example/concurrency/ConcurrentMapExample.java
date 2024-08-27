package org.example.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);

        Integer value = map.get("key2");
        System.out.println("value for key2 = " + value);

        map.forEach((key, val) -> System.out.println(key + ": " + val));
    }
}
