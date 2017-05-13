package algorithms.cs;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class WindowMaxTest {
    @Test
    public void calc() {
        assertEquals("7 7 5 6 6", WindowMax.calc(new ByteArrayInputStream(("8\n" +
                "2 7 3 1 5 2 6 2\n" +
                "4").getBytes())));

        assertEquals("2 1 5", WindowMax.calc(new ByteArrayInputStream(("3\n" +
                "2 1 5\n" +
                "1").getBytes())));

        assertEquals("73 97 97 97 97 97 97 97 42", WindowMax.calc(new ByteArrayInputStream(("15\n" +
                "73 65 24 14 44 20 65 97 27 6 42 1 6 41 16\n" +
                "7").getBytes())));

        assertEquals("79 79 79 79", WindowMax.calc(new ByteArrayInputStream(("15\n" +
                "16 79 20 19 43 72 78 33 40 52 70 79 66 43 60\n" +
                "12").getBytes())));

        assertEquals("83 83 77 77 48 72 72 72 72 72 58", WindowMax.calc(new ByteArrayInputStream(("15\n" +
                "27 83 29 77 6 3 48 2 16 72 46 38 55 2 58\n" +
                "5").getBytes())));

        assertEquals("61 90 90 90 84 84 25 25 25 78 78 78 47", WindowMax.calc(new ByteArrayInputStream(("15\n" +
                "34 51 61 90 26 84 2 25 7 8 25 78 21 47 25\n" +
                "3").getBytes())));
        assertEquals("93 93 93 93", WindowMax.calc(new ByteArrayInputStream(("15\n" +
                "28 7 64 40 68 86 80 93 4 53 32 56 68 18 59\n" +
                "12").getBytes())));

        assertEquals("7 7 5 6 6", WindowMax.calc(new ByteArrayInputStream(("8\n" +
                "2 7 3 1 5 2 6 2\n" +
                "4").getBytes())));

        assertEquals("9 9 9 8", WindowMax.calc(new ByteArrayInputStream(("11\n" +
                "6 4 9 5 3 5 7 4 4 7 8\n" +
                "8").getBytes())));

        assertEquals("889 889 724 218 508 508 41 561 811 852", WindowMax.calc(new ByteArrayInputStream(("11\n" +
                "176 889 724 93 218 508 41 28 561 811 852\n" +
                "2").getBytes())));

    }

    @Test
    public void calc2() {

    }
    @Test
    public void calc22() {

    }

}