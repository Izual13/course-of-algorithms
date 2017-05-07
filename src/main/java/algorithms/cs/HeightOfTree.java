package algorithms.cs;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeightOfTree {
    public static void main(String[] args) {
        System.out.println(calc(System.in));
    }


    static int calc(InputStream is) {
        Scanner scanner = new Scanner(is);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        Node root = null;

        for (int i = 0; i < n; i++) {
            int index = scanner.nextInt();
            if (nodes[i] == null) {
                nodes[i] = new Node();
            }

            if (index == -1) {
                root = nodes[i];
                root.setId(i);
            } else {
                Node node = nodes[index];
                if (node == null) {
                    node = new Node();
                    nodes[index] = node;
                }
                node.add(nodes[i]);
                nodes[i].setParent(node);
                nodes[i].setId(i);

            }
        }

        return height(nodes, root.id);
    }

    private static class Node {
        private int id;
        private List<Node> branches = new ArrayList<>();
        private Node parent;

        private void add(Node node) {
            branches.add(node);
        }

        void setParent(Node parent) {
            this.parent = parent;
        }


        void setId(int id) {
            this.id = id;
        }

    }

    private static int height(Node[] nodes, int rootId) {
        int[] heights = new int[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            if (node.branches.isEmpty()) {
                heights[i] = 1;
                Node parent = node.parent;
                while (parent != null) {
                    int height = heights[parent.id];
                    if (height == 0) {
                        heights[parent.id] = heights[node.id] + 1;
                    } else {
                        heights[parent.id] = Math.max(heights[node.id] + 1, heights[parent.id]);
                    }
                    node = parent;
                    parent = parent.parent;
                }
            }
        }

        return heights[rootId];
    }


}
