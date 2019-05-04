package algorithms.csc;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DifferentTerms {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int sum = 0;
        int i = 1;
        ArrayList<Integer> result = new ArrayList<>();

        while (true) {
            if (sum + i <= n) {
                sum += i;
                result.add(i++);
            } else {
                break;
            }
        }

        if (sum < n) {
            int lastIndex = result.size() - 1;
            Integer lastValue = result.get(lastIndex);
            result.set(lastIndex, n - sum + lastValue);
        }

        System.out.println(result.size());
        System.out.println(result.stream().map(Objects::toString).collect(Collectors.joining(" ")));
    }

}
