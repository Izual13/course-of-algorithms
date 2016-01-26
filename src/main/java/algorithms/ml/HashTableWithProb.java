package algorithms.ml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Hash table with prob
 */
public class HashTableWithProb {


    public static final String FAIL = "FAIL";
    public static final String OK = "OK";

    public static void main(String[] args) {
        String s = "+ hello\n" +
                "+ bye\n" +
                "? bye\n" +
                "+ bye\n" +
                "- bye\n" +
                "? bye\n" +
                "? hello";
        start(new BufferedInputStream(new ByteArrayInputStream(s.getBytes())), System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);

        HashTableWithProb hashTable = new HashTableWithProb();
        while (in.hasNext()) {
            String action = in.next();
            String value = in.next();
            out.println(action + " " + value);

            String result = "";
            switch (action) {
                case "+":
                    result = hashTable.add(value);
                    break;
                case "?":
                    result = hashTable.check(value);
                    break;
                case "-":
                    result = hashTable.remove(value);
                    break;
            }
            out.println(result);
        }
    }

    private String add(String value) {
        return FAIL;
    }


    private String check(String value) {
        return OK;
    }

    private String remove(String value) {
        return OK;
    }


}


