package algorithms.cs;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class StackWithMaxTest {
    @Test
    public void calc() {

        assertEquals("2\n" +
                "2", StackWithMax.calc(new ByteArrayInputStream(("5\n" +
                "push 2\n" +
                "push 1\n" +
                "max\n" +
                "pop\n" +
                "max").getBytes())));

        assertEquals("", StackWithMax.calc(new ByteArrayInputStream(("3\n" +
                "push 1\n" +
                "push 7\n" +
                "pop").getBytes())));

        assertEquals("9\n" +
                "9\n" +
                "9\n" +
                "9", StackWithMax.calc(new ByteArrayInputStream(("10\n" +
                "push 2\n" +
                "push 3\n" +
                "push 9\n" +
                "push 7\n" +
                "push 2\n" +
                "max\n" +
                "max\n" +
                "max\n" +
                "pop\n" +
                "max").getBytes())));

        assertEquals("2\n" +
                "1", StackWithMax.calc(new ByteArrayInputStream(("5\n" +
                "push 1\n" +
                "push 2\n" +
                "max\n" +
                "pop\n" +
                "max").getBytes())));
    }

}