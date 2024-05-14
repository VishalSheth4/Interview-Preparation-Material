import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final Queue<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.queue = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // Remove the key from the queue and add it to the end
        queue.remove(key);
        queue.offer(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update the value of the existing key
            cache.put(key, value);
            // Remove the key from the queue and add it to the end
            queue.remove(key);
            queue.offer(key);
        } else {
            if (cache.size() >= capacity) {
                // Remove the least recently used key from the cache and queue
                int removedKey = queue.poll();
                cache.remove(removedKey);
            }
            // Add the new key-value pair to the cache and queue
            cache.put(key, value);
            queue.offer(key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Output: 1
        cache.put(3, 3);
        System.out.println(cache.get(2)); // Output: -1 (not found)
        cache.put(4, 4);
        System.out.println(cache.get(1)); // Output: -1 (not found)
        System.out.println(cache.get(3)); // Output: 3
        System.out.println(cache.get(4)); // Output: 4
    }
}
z