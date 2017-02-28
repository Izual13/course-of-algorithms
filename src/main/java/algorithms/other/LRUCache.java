package algorithms.other;

import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private LRUCache(int initialCapacity,
                     float loadFactor,
                     int maxEntries) {
        super(initialCapacity, loadFactor, true);
        this.maxEntries = maxEntries;
    }

    private LRUCache(int initialCapacity,
                     int maxEntries) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, maxEntries);
    }

    LRUCache(int maxEntries) {
        this(DEFAULT_INITIAL_CAPACITY, maxEntries);
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }
}
