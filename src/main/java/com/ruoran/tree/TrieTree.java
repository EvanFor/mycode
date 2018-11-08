package com.ruoran.tree;

import java.io.IOException;

public class TrieTree {

    private Node root;
    private static int SIZE = 26;

    public static class Node {
        private int num;
        private Node[] son;
        private char val;
        private boolean isLeaf;

        public Node() {
            num = 1;
            isLeaf = false;
            son = new Node[SIZE];
        }
    }

    public TrieTree() {
        root = new Node();
    }

    public void insert(String string) {
        Node node = root;
        char[] letters = string.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new Node();
                node.son[pos].val = letters[i];
            } else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isLeaf = true;
    }

    public boolean contains(String string) {
        Node node = root;
        char[] letters = string.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isLeaf;
    }

    public int countPrefix(String prefix) {
        Node node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return 0;
            }
        }
        return node.num;
    }

    public String hasPrefix(String prefix) {
        Node node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return null;
            }
        }

        preTraverse(node, prefix);

        return null;
    }

    public void preTraverse(Node node, String prefix) {
        if (!node.isLeaf) {
            for (Node child : node.son) {
                if (child != null) {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }

    public static void main(String[] args) throws IOException {
        TrieTree tree = new TrieTree();
        String[] dictionaryData = {"hello", "hex", "student", "computer", "sorry", "acm", "people", "experienced", "who", "reminds", "everyday", "almost"};

        for (String str : dictionaryData) {
            tree.insert(str);
        }

        System.out.println(tree.hasPrefix("he"));
    }
}



