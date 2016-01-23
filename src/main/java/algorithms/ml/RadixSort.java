package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Radix sort
 */
public class RadixSort {

    private static final int BITS_PER_BYTE = 8;

    public static void main(String[] args) {
        start(System.in, System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);

        int n = in.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextLong();
        }


        sort(numbers);

        for (long i : numbers) {
            out.print(i + " ");
        }
    }


    static void sort(long[] a) {
        int BITS = 64;
        int W = BITS / BITS_PER_BYTE;
        int R = 1 << BITS_PER_BYTE;
        int MASK = R - 1;

        int N = a.length;
        long[] aux = new long[N];

        for (int d = 0; d < W; d++) {

            int[] count = new int[R + 1];
            for (long i : a) {
                int c = (int) (i >> BITS_PER_BYTE * d) & MASK;
                count[c + 1]++;
            }

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            if (d == W - 1) {
                int shift1 = count[R] - count[R / 2];
                int shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            for (long i : a) {
                int c = (int) (i >> BITS_PER_BYTE * d) & MASK;
                aux[count[c]++] = i;
            }

            System.arraycopy(aux, 0, a, 0, N);
        }
    }


}


