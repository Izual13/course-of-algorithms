package algorithms.greedy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * покрыть отрезки точками
 */
public class Points {
    public static void main(String[] args) {
        String s = "4\n" +
                "4 7\n" +
                "1 3\n" +
                "2 5\n" +
                "5 6";
        start(new ByteArrayInputStream(s.getBytes()), System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.nextInt(), in.nextInt());
        }

        Arrays.asList(pairs).stream().forEach(out::println);

    }

    static class Pair {
        int x1, x2;

        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public String toString() {
            return "Pair{x1=" + x1 + ", x2=" + x2 + '}';
        }
    }
}
