package vissheth;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3); // Creating an LRU cache with capacity 3

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        System.out.println("Cache content after adding 3 elements: " + cache);

        // Accessing an element, it will become the most recently used
        cache.get(1);
        System.out.println("Cache content after accessing element with key 1: " + cache);

        // Adding a new element, it will replace the least recently used
        cache.put(4, "Four");
        System.out.println("Cache content after adding a new element with key 4: " + cache);
    }
}
