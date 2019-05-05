package algorithms.csc;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HuffmanDecode {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int chars = s.nextInt();
        int ignore = s.nextInt();


        TreeMap<String, Character> map = new TreeMap<>();

        for (int i = 0; i < chars; i++) {
            char c = s.next().toCharArray()[0];
            String code = s.next();
            map.put(code, c);
        }

        char[] src = s.next().toCharArray();

        HuffmanNode root = buildTree(map);

        StringBuilder result = new StringBuilder();


        findByCode(src, root, result);

        System.out.println(result);
    }

    private static HuffmanNode buildTree(Map<String, Character> map) {
        HuffmanNode root = new HuffmanNode();
        map.forEach(root::add);

        return root;
    }

    private static void findByCode(char[] src, HuffmanNode root, StringBuilder result) {
        HuffmanNode currentNode = root;
        int index = 0;
        while (src.length != index) {
            char code = src[index];
            if (currentNode.code != null && currentNode.code.equals(code)) {
                index++;
                if (currentNode.c != null) {
                    result.append(currentNode.c);
                    currentNode = root;
                } else if (currentNode.left != null && currentNode.left.code.equals(src[index])) {
                    currentNode = currentNode.left;
                } else if (currentNode.right != null && currentNode.right.code.equals(src[index])) {
                    currentNode = currentNode.right;
                }
            } else if (currentNode.left != null && currentNode.left.code.equals(code)) {
                currentNode = currentNode.left;
            } else if (currentNode.right != null && currentNode.right.code.equals(code)) {
                currentNode = currentNode.right;
            }
        }


    }


    static class HuffmanNode {
        Character c;
        Character code;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode add(String s, Character character) {

            if (s.length() == 0) {
                c = character;
                return this;
            }

            char firstChar = s.toCharArray()[0];
            if (firstChar == '0') {
                getLeft().add(s.substring(1), character).code = firstChar;
            } else {
                getRight().add(s.substring(1), character).code = firstChar;
            }

            return this;
        }


        HuffmanNode getLeft() {
            if (left == null) {
                left = new HuffmanNode();
            }

            return left;
        }

        HuffmanNode getRight() {
            if (right == null) {
                right = new HuffmanNode();
            }

            return right;
        }
    }
}

