package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * поиск простых чисел
 * генерация решета эратосфена
 */
public class SimpleNumbers {


    public static void main(String[] args) {
        start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        List<Integer> numbers = generateSieve(n+1);

        List<Integer> dividers = new ArrayList<>();

        int i = 0;
        while (n != 1) {
            int divider = numbers.get(i);
            if (n % divider == 0) {
                dividers.add(divider);
                n = n / divider;
                i = -1;
            }
            i++;
        }

        dividers.forEach((x) -> out.print(x + " "));

    }

    private static List<Integer> generateSieve(int n) {
        Boolean[] numbers = new Boolean[n];
        for (int i = 2; i < n; i++) {
            if (numbers[i] == null) {
                numbers[i] = true;
                int j = 1;
                int sum;
                while ((sum = (++j) * i) < n) {
                    numbers[sum] = false;
                }
            }
        }
        return IntStream.range(2, numbers.length)
                .filter(i -> numbers[i])
                .mapToObj(i -> i)
                .collect(Collectors.toList());

    }
}
