package com.gold.algorithm.learnblock.binarytree.pojo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author goldhuang
 * @Description: 二叉树 node
 * @date 2021-02-19
 */
@Data
public class TreeNode {

    private Integer val;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    /**
     * 构建一颗简单的完全二叉树 子节点可能包含 null
     */
    public static TreeNode getInstance(Integer[] data) {

        // 1. 初始化 node
        List<TreeNode> nodes = Lists.newLinkedList();
        for (Integer i : data) {
            nodes.add(i == null ? null : new TreeNode(i));
        }

        // 2. 组合 node
        TreeNode root = nodes.get(0);
        int nullNum = 0;
        for (int i = 1; i < nodes.size(); i++) {
            // 奇数
            if (i % 2 != 0) {
                int pIndex = (i - 1) / 2 + nullNum;
                TreeNode p = nodes.get(pIndex);
                p.setLeft(nodes.get(i));
            } else {
                int pIndex = (i - 2) / 2 + nullNum;
                TreeNode p = nodes.get(pIndex);
                p.setRight(nodes.get(i));

                if (nodes.get(i - 1) == null) {
                    nullNum++;
                }
            }
        }
        return root;
    }

    /**
     * 构建一颗简单的完全二叉树 子节点可能包含 null
     */
    public static TreeNode createBinaryTreeWithNonNull(int[] data, int index) {
        TreeNode node = null;
        if (index >= data.length) {
            return node;
        }

        int val = data[index];
        node = new TreeNode(val);
        node.left = createBinaryTreeWithNonNull(data, 2 * index + 1);
        node.right = createBinaryTreeWithNonNull(data, 2 * index + 2);

        return node;
    }

    /**
     *          1
     *        /  \
     *       2    3
     *     / \   / \
     *    4   5 n   7
     *
     * @return
     */
    public static TreeNode getInstance() {
        Integer[] data = {1, 2, 3, 4, 5, null, 7};
        return getInstance(data);
    }

    public static void main(String[] args) {
        TreeNode instance = getInstance();
        System.out.println(instance);

//        int[] data = {1,2,3,4,5,6,7};
//        TreeNode root = createBinaryTreeWithNonNull(data, 0);
//        System.out.println(root);
    }
}
