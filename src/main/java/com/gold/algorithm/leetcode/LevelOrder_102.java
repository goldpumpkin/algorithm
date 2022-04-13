package com.gold.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 关联：广度优先遍历
 */
public class LevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> c = new ArrayDeque<>();
        c.offer(root);

        while (!c.isEmpty()) {

            final Queue<TreeNode> n = new ArrayDeque<>();
            List<Integer> level = new ArrayList<>();

            // 这一步可优化 queue 的 size 是知道的
            while (!c.isEmpty()) {
                final TreeNode node = c.poll();
                level.add(node.val);

                final TreeNode left = node.left;
                final TreeNode right = node.right;
                if (left != null) {
                    n.offer(left);
                }
                if (right != null) {
                    n.offer(right);
                }
            }

            c = n;
            result.add(level);
        }

        return result;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


    }

}

