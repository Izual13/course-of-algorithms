package algorithms.other;

import java.util.HashMap;
import java.util.Map;

public class Pairs {

    public static void main(String[] args) {
        long[] a1 = { 3, 4, 3, 100, 42 };
        long[] a2 = { 4, 3, 6, 42, 3 };
        int top = 0;
        Map<Long, Struct> map = new HashMap<>();


        for (int i = 0; i < a1.length; i++) {
            Struct struct1 = map.computeIfAbsent(a1[i], (ignore) -> new Struct());

            Struct struct2 = map.computeIfAbsent(a2[i], (ignore) -> new Struct());

            if (struct1 == struct2) {
                top++;
            } else {
                if (struct1.incF1()) {
                    top++;
                }
                if (struct2.incF2()) {
                    top++;
                }
            }

            System.out.println("top " + (i + 1) + ": " + top);
        }
    }

    private static class Struct {
        private int f1 = 0;
        private int f2 = 0;
        private int lastCalcValue = 0;

        private int calc() {
            lastCalcValue = Math.min(f1, f2);
            return lastCalcValue;
        }

        private boolean incF1() {
            f1++;
            return lastCalcValue != calc();
        }

        private boolean incF2() {
            f2++;
            return lastCalcValue != calc();
        }
    }
}
