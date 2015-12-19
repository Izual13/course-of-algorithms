package introduction;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * наибольший общий делитель
 */
public class NOD {
    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner sc = new Scanner(is);

        long n = sc.nextLong();
        long m = sc.nextLong();
        if (n > m) {
            out.println(nod(n, m));
        } else {
            out.println(nod(m, n));
        }


    }

    static long nod(long x, long y) {
        while (x % y != 0) {
            long l = x % y;
            x = y;
            y = l;
        }

        return y;
    }
}
