package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Сортировка вставками
 */
public class InsertSort {


    public static void main(String[] args) {
        start(System.in, System.out);
    }

    private static int length = 0;
    private static int size = 0;
    private static int[] m = new int[size];


    public static void start(InputStream is, PrintStream out) {
        length = 0;
        size = 0;
        m = new int[size];


        Scanner in = new Scanner(is);

        while (in.hasNextInt()) {
            int i = in.nextInt();
            addInt(i);
        }

        out.println(mToString());
    }

    private static void addInt(int i) {
        if (length == size) {
            size += 10;
            m = Arrays.copyOf(m, size);
        }

        if (length == 0) {
            m[length] = i;
        } else {
            for (int j = 0; j <= length; j++) {
                if (m[j] >= i) {
                    System.arraycopy(m, j, m, j + 1, length - j);
                    m[j] = i;
                    length++;
                    return;
                }
            }
            m[length] = i;
        }

        length++;
    }

    private static String mToString() {
        StringBuilder buffer = new StringBuilder();
        for (int j = 0; j < length; j++) {
            buffer.append(m[j]).append(" ");

        }
        return buffer.toString();
    }
}
