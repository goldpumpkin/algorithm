package com.gold.algorithm.learnblock.binarytree;

import com.gold.algorithm.learnblock.binarytree.pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author goldhuang
 * @Description: 求一棵树的最大深度
 * 思路：
 * 1. 递归求最大深度
 * 2. 层次遍历
 * @date 2021-04-07
 */
public class BinaryTreeLargestDepth {

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        System.out.println(depthLargest(root));

        System.out.println(level(root));

    }

    /**
     * 求二叉树的最大深度
     * 思路：当前节点的深度等于左右子节点的最大深度
     */
    public static int depthLargest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 1;

        int left = depthLargest(root.getLeft());
        int right = depthLargest(root.getRight());

        return depth + Math.max(left, right);
    }

    /**
     * 思路：遍历所有层
     */
    public static int level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int front = 0;
        int tail = queue.size();
        int level = 1;
        int nextLevelNodeNum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            front++;

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nextLevelNodeNum++;
            }

            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nextLevelNodeNum++;
            }

            if (front == tail) {
                level++;
                front = 0;
                tail = nextLevelNodeNum;
            }
        }

        return level;

    }

}
