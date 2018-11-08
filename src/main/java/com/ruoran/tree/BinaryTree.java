package com.ruoran.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static class TreeNode {
        Object val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(Object val) {
            this.val = val;
        }
    }

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public List<Object> breadthFirstSearch(TreeNode root) {
        ArrayList<Object> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.offer(tree.left);
            }

            if (tree.right != null) {
                queue.offer(tree.right);
            }

            lists.add(tree.val);
        }
        return lists;
    }

    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public List<Object> depthFirstSearch(TreeNode root) {
        ArrayList<Object> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            if (tree.right != null) {
                stack.push(tree.right);
            }

            if (tree.left != null) {
                stack.push(tree.left);
            }

            lists.add(tree.val);
        }
        return lists;
    }

    /**
     * A
     * /   \
     * B     C
     * / \   / \
     * D   E F   G
     * \    /
     * H   I
     *
     * @return
     */

    private TreeNode create() {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");

        A.left = B;
        A.right = C;

        B.left = D;
        B.right = E;

        C.left = F;
        C.right = G;

        D.right = H;
        F.left = I;

        return A;
    }

    private void depthTraversal(TreeNode node) {
        if (node != null) {
            depthTraversal(node.left);
            depthTraversal(node.right);
            System.out.print(node.val + "  ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.depthTraversal(tree.create());
    }
}
