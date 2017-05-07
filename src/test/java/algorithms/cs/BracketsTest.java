package algorithms.cs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BracketsTest {
    @Test
    public void calc() {
        assertEquals("Success", Brackets.calc("([](){([])})".toCharArray()));
        assertEquals("5", Brackets.calc("()[]}".toCharArray()));
        assertEquals("7", Brackets.calc("{{[()]]".toCharArray()));
        assertEquals("1", Brackets.calc("(()".toCharArray()));
        assertEquals("6", Brackets.calc("(((((((((())))".toCharArray()));
        assertEquals("3", Brackets.calc("{[}".toCharArray()));
        assertEquals("3", Brackets.calc("()({}".toCharArray()));
        assertEquals("3", Brackets.calc("[]([]".toCharArray()));
        assertEquals("5", Brackets.calc("[]()([]".toCharArray()));
        assertEquals("7", Brackets.calc("[](())([]".toCharArray()));
        assertEquals("10", Brackets.calc("foo(bar[i)".toCharArray()));
    }
}