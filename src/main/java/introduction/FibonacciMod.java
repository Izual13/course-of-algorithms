package introduction;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * последняя цифра большого числа Фибоначчи
 */
public class FibonacciMod {
    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner sc = new Scanner(is);
        long f1 = 1;
        long f2 = 1;
        long n = sc.nextLong();
        for (int i = 2; i < n; i++) {
            long f3 = f1 + f2;
            f1 = f2 % 10;
            f2 = f3 % 10;
        }

        out.println(f2);
    }
}
