package algorithms.other;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;


public class LRUCacheTest {
    @Test
    public void test() {
        Map<Integer, String> cache = new LRUCache<>(5);
        for (int i = 0; i < 10; i++) {
            cache.put(i, "v" + i);
        }

        assertEquals("{5=v5, 6=v6, 7=v7, 8=v8, 9=v9}", cache.toString());
        assertNull(cache.get(3));
        assertNotNull(cache.get(5));

        for (int i = 10; i < 14; i++) {
            cache.put(i, "a");
        }
        assertEquals("{5=v5, 10=a, 11=a, 12=a, 13=a}", cache.toString());
        cache.get(5);
        assertEquals("{10=a, 11=a, 12=a, 13=a, 5=v5}", cache.toString());

        cache.put(42, "b");
        assertEquals("{11=a, 12=a, 13=a, 5=v5, 42=b}", cache.toString());
    }
}