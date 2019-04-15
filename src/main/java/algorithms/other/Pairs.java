package algorithms.other;

import java.util.HashMap;
import java.util.Map;

public class Pairs {

    public static void main(String[] args) {
        long[] a1 = {3, 4, 3, 100, 42};
        long[] a2 = {4, 3, 6, 42, 3};
        int t = 3;
        Map<Long, Struct> map = new HashMap<>();


        for (int i = 0; i < t; i++) {
            map.computeIfAbsent(a1[i], (ignore) -> new Struct()).incF1();
            map.computeIfAbsent(a2[i], (ignore) -> new Struct()).incF2();
        }

        System.out.println(map.values().stream().mapToInt(Struct::calc).sum());
    }

    private static class Struct {
        private int f1 = 0;
        private int f2 = 0;

        private int calc() {
            return Math.min(f1, f2);
        }

        private void incF1() {
            f1++;
        }

        private void incF2() {
            f2++;
        }
    }
}
