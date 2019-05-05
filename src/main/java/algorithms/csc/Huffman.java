package algorithms.csc;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Huffman {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String next = s.next();


        char[] charArray = next.toCharArray();

        Map<Character, Long> collect = IntStream.range(0, charArray.length).mapToObj(i -> charArray[i]).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        TreeSet<HuffmanNode> set = collect
                .entrySet()
                .stream()
                .map(e -> new HuffmanNode(e.getKey(), e.getValue()))
                .collect(Collectors.toCollection(TreeSet::new));


        while (set.size() >= 2) {
            HuffmanNode first = set.pollFirst();
            HuffmanNode second = set.pollFirst();
            HuffmanNode newNode = new HuffmanNode(first.c, first.frequency + second.frequency);
            newNode.left = first;
            newNode.right = second;
            set.add(newNode);
        }


        HuffmanNode root = set.pollFirst();
        fillTree(root);

        LinkedHashMap<Character, String> map = new LinkedHashMap<>();
        toMap(root, map);

        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            result.append(map.get(c));
        }


        System.out.println(map.size() + " " + result.length());
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println(result);
    }

    private static void fillTree(HuffmanNode tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null && tree.right != null) {
            tree.c = null;
        }

        if (tree.left == null && tree.right == null && tree.code.equals("")) {
            tree.code = "0";
        }

        if (tree.left != null) {
            tree.left.code = tree.code + "1";
            fillTree(tree.left);
        }
        if (tree.right != null) {
            tree.right.code = tree.code + "0";
            fillTree(tree.right);
        }
    }


    private static void toMap(HuffmanNode tree, Map<Character, String> map) {

        if (tree == null) {
            return;
        }

        if (tree.c == null) {
            toMap(tree.right, map);
            toMap(tree.left, map);
        } else {
            map.put(tree.c, tree.code);
        }


    }


    static class HuffmanNode implements Comparable<HuffmanNode> {
        Character c;
        Long frequency;
        HuffmanNode left;
        HuffmanNode right;
        String code = "";

        Character getChar() {
            return c;
        }

        Long getFrequency() {
            return frequency;
        }

        HuffmanNode(char c, long frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            Comparator<HuffmanNode> comparator = Comparator.comparing(HuffmanNode::getFrequency).thenComparing(Comparator.comparing(HuffmanNode::getChar).reversed());
            return comparator.compare(this, o);
        }
    }
}

