package ru.fyodorov.lesson5;

/**
 * Экземпляр класса @code Entry представляет пару 'ключ, значение' - элемент карты.
 * @param <K> ключ элемента.
 * @param <V> значение ключа.
 */
public class Entry<K, V> {
    /**
     * Поля класса
     */
    final K key;
    V value;
    Entry<K, V> next;

    /**
     * Конструктор класса
     *
     * @param key ключ
     * @param value значение
     * @param next ссылка на следующий узел
     */
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry getNext() {
        return next;
    }

    /**
     * Переопределенный метод equals
     *
     * @param o объект
     * @return возвращаем true если ключ и значение одинаковые, в другом случае - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Entry) {
            Entry entry = (Entry) o;
            return key.equals (entry.getKey())&&value.equals(entry.getValue());
        }
        return false;
    }

    /**
     * Переопределенный метод hashCode
     *
     * @return если ключ и значения не найдены возвращает null, в другом случае возвращает hashCode
     */
    @Override
    public int hashCode() {
        int hash = 12;
        hash = 19 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 19 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }

    /**
     * Переопределенный метод toString
     *
     * @return возвращает объекты
     */
    @Override
    public String toString() {
        return getKey() +"="+ getValue() +"";
    }
}
