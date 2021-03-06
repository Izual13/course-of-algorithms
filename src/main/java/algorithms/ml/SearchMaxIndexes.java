package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Даны два массива целых чисел одинаковой длины A[0..n−1] и B[0..n−1].
 * Необходимо найти первую пару индексов i0 и j0, i0≤j0, такую что A[i0]+B[j0]=max{A[i]+B[j],где0≤i<n,0≤j<n,i≤j}.
 */
public class SearchMaxIndexes {


    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        fillArray(in, a);

        int maxIndexA = 0;
        int maxIndexB = 0;
        int tmpIndexA = 0;
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();

            if (a[tmpIndexA] < a[i]) {
                tmpIndexA = i;
            }

            if (a[maxIndexA] + b[maxIndexB] < a[tmpIndexA] + b[i] && i >= tmpIndexA) {
                maxIndexB = i;
                maxIndexA = tmpIndexA;
            }
        }

        out.print(maxIndexA + " " + maxIndexB);

    }

    private static void fillArray(Scanner in, int[] m) {
        for (int i = 0; i < m.length; i++) {
            m[i] = in.nextInt();
        }
    }

}
