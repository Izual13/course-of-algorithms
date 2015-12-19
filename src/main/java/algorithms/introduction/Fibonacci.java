package algorithms.introduction;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * небольшое число Фибоначчи
 */
public class Fibonacci {
    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        long f1 = 1;
        long f2 = 1;
        long n = in.nextLong();
        for (int i = 2; i < n; i++) {
            long f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        out.println(f2);
    }
}
