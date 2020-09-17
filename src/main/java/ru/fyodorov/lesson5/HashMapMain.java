package ru.fyodorov.lesson5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fyodorov Alexandr
 * @code HashMapMain
 *
 * Точка входа в программу
 */
public class HashMapMain {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap();
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        hashMap.put(3, "Andrey");
        System.out.println("Реализация MyHashMap:");
        System.out.println(hashMap.entrySet());
        System.out.println(hashMap.values());
        System.out.println(hashMap.keySet());
        System.out.println("---------------------------------");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Ivan");
        map.put(2, "Petr");
        map.put(3, "Andrey");
        System.out.println("Реализация HashMap:");
        System.out.println(map.entrySet());
        System.out.println(map.values());
        System.out.println(map.keySet());
    }
}
