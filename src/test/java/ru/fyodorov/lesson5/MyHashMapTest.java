package ru.fyodorov.lesson5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

public class MyHashMapTest {
    private MyHashMap <Integer, String> hashMap;

    @Before
    public void createNewHashTable() {
        hashMap = new MyHashMap<>();
    }

    /**
     * Добавляет ли метод put ключ-значение в HashMap
     */
    @Test
    public void put() {
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        Object actual = hashMap.get(1);
        Assert.assertEquals("Ivan", actual);
        actual = hashMap.get(2);
        Assert.assertEquals("Petr", actual);
    }

    /**
     * Возвращает ли метод get верное значение
     */
    @Test
    public void get() {
        hashMap.put(1, "Ivan");
        Assert.assertEquals("Ivan", hashMap.get(1));
    }

    /**
     * Удаляет ли метод remove объект, который указали
     */
    @Test
    public void removeTrue() {
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        hashMap.remove(1);
        Assert.assertFalse(hashMap.contains(1));
        Assert.assertTrue(hashMap.contains(2));
    }

    /**
     * Не влияет ли удаление на новый HashMap
     */
    @Test
    public void removeDoesNotEffectNewHashMap() {
        hashMap.remove(1);
        Assert.assertEquals(0, hashMap.getSize());
    }

    /**
     * Уменьшает ли метод remove размер HashMap при удалении объекта
     */
    @Test
    public void removeSize() {
        hashMap.put(1, "Ivanov");
        hashMap.put(2, "Petrov");
        hashMap.remove(1);
        Assert.assertEquals(1, hashMap.getSize());
        hashMap.remove(2);
        Assert.assertEquals(0, hashMap.getSize());
    }

    /**
     * Содержит ли метод contains значение, если содержит вернет try
     */
    @Test
    public void contains() {
        hashMap.put(1, "Ivan");
        Assert.assertTrue(hashMap.contains(1));
    }

    /**
     * Возвращает ли правильное значение метод getSize
     */
    @Test
    public void getSize() {
        hashMap.put(1, "Ivanov");
        Assert.assertEquals(1, hashMap.getSize());
        hashMap.put(2, "Petrov");
        Assert.assertEquals(2, hashMap.getSize());
    }

    /**
     * Возвращает ли getSize 0, если HashMap пустой
     */
    @Test
    public void testGetSizeIfMapIsEmpty() {
        Assert.assertEquals(0, hashMap.getSize());
    }

    /**
     * Вщзвращает ли метод true, если HashMap пустой
     */
    @Test
    public void isEmptyTrue() {
        Assert.assertTrue(hashMap.isEmpty());
    }

    /**
     * Вщзвращает ли метод false, если HashMap заполнен
     */
    @Test
    public void isEmptyFalse() {
        hashMap.put(1, "Ivan");
        Assert.assertFalse(hashMap.isEmpty());
    }

    /**
     * Не переписывает ли метод put ключи с одинаковым хешкодом
     */
    @Test
    public void putHash() {
        hashMap.put(5, "Ivan");
        hashMap.put(10, "Petr");
        Assert.assertEquals("Ivan",hashMap.get(5));
        Assert.assertEquals("Petr",hashMap.get(10));
    }

    /**
     * Возвратит ли метод все ключи и значения
     */
    @Test
    public void entrySet(){
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        Set<Entry<Integer, String>> set;
        set = hashMap.entrySet();
        for (Entry<Integer, String> entry : hashMap.bucket){
            if (entry != null){
                while (entry.next != null){
                    Assert.assertTrue(set.contains(entry));
                    entry = entry.next;
                }
                Assert.assertTrue(set.contains(entry));
            }
        }
    }

    /**
     * Возвратит ли метод все значения
     */
    @Test
    public void values(){
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        Collection<String> collection;
        Collection<String> collection1;
        collection = hashMap.values();
        collection1 = hashMap.values();
        System.out.println(collection1);
        Assert.assertTrue(collection.containsAll(collection1));
    }

    /**
     * Возвратит ли метод все ключи
     */
    @Test
    public void keySet(){
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Petr");
        Set<Integer> set1;
        Set<Integer> set2;
        set1 = hashMap.keySet();
        set2 = hashMap.keySet();
        Assert.assertTrue(set1.containsAll(set2));
    }
}