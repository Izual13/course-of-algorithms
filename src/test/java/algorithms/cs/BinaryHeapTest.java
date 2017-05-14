package algorithms.cs;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class BinaryHeapTest {
    @Test
    public void calc() {
        assertEquals("3\n" +
                "1 4\n" +
                "0 1\n" +
                "1 3", BinaryHeap.calc(new ByteArrayInputStream(("5\n" +
                "5 4 3 2 1").getBytes())));
    }

}