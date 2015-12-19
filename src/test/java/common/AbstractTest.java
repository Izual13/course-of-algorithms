package common;

import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class AbstractTest {
    protected ByteArrayOutputStream output;


    @Before
    public void setup() {
        output = new ByteArrayOutputStream();
    }

    protected ByteArrayInputStream is(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    protected PrintStream out() {
        return new PrintStream(output);
    }
}
