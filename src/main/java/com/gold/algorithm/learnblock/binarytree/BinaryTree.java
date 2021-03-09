package com.gold.algorithm.learnblock.binarytree;


import com.gold.algorithm.learnblock.binarytree.pojo.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @author goldhuang
 * @Description: 二叉树 - 多种遍历方式
 *       1. 前序
 *       2. 中序
 *       3. 后序
 *       4. 广度
 *       5. 深度
 *       6. 层
 * @date 2021-02-19
 */
public class BinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();

        preorderTraversal(root);

        System.out.println();
        System.out.println("--------------------------");

        inorderTraversal(root);

        System.out.println();
        System.out.println("--------------------------");

        postorderTraversal(root);

        System.out.println();
        System.out.println("--------------------------");

        nonRecursivePre(root);

    }

    /**
     * 前序遍历：根节点在前面
     * 遍历顺序：根节点 - 左子树 - 右子树
     * @param root
     */
    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getVal());
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }

    /**
     * 中序遍历：根节点在中间
     * 遍历顺序：左子树 - 根节点 - 右子树
     * @param root
     */
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.getLeft());
        System.out.print(root.getVal());
        inorderTraversal(root.getRight());
    }

    /**
     * 后序遍历：根节点在后面
     * 遍历顺序：左子树 - 右子树- 根节点
     * @param root
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.getLeft());
        postorderTraversal(root.getRight());
        System.out.print(root.getVal());
    }

    /**
     * 非递归 - 先序遍历
     * @param root
     */
    public static void nonRecursivePre(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !nodes.empty()) {
            while (curr != null) {
                System.out.print(curr.getVal());
                nodes.push(curr);
                curr = curr.getLeft();
            }

            if (!nodes.empty()) {
                TreeNode treeNode = nodes.pop();
                curr = treeNode.getRight();
            }
        }
    }

    /**
     * 非递归 - 中序遍历
     * @param root
     */
    public static void nonRecursiveIn(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !nodes.empty()) {
            while (curr != null) {
                nodes.push(curr);
                curr = curr.getLeft();
            }

            if (!nodes.empty()) {
                TreeNode pop = nodes.pop();
                System.out.println(pop.getVal());
                curr = pop.getRight();
            }
        }
    }

    /**
     * 非递归 - 后序遍历
     * @param root
     */
    public static void nonRecursivePost(TreeNode root) {

    }
}
