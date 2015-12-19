package introduction;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * огромное число Фибоначчи по модулю
 */
public class FibonacciX {
    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner sc = new Scanner(is);
        long n = sc.nextLong();
        long mod = sc.nextLong();
        out.println(fff(n, mod));
    }


    private static long fff(long n, long mod) {
        long[] m = {1, 1, 1, 0};
        long[] result = {1, 0};

        while (n > 0) {
            if ((n & 1) == 1) {
                long[] tmpM = {0, 0};
                tmpM[0] = (result[0] * m[0] + result[1] * m[2]) % mod;
                tmpM[1] = (result[0] * m[1] + result[1] * m[3]) % mod;
                result = tmpM;
            }
            long[] tmpM = {0, 0, 0, 0};
            tmpM[0] = (m[0] * m[0] + m[1] * m[2]) % mod;
            tmpM[1] = (m[0] * m[1] + m[1] * m[3]) % mod;
            tmpM[2] = (m[2] * m[0] + m[3] * m[2]) % mod;
            tmpM[3] = (m[2] * m[1] + m[3] * m[3]) % mod;
            m = tmpM;

            n >>= 1;
        }
        return result[1];
    }
}
