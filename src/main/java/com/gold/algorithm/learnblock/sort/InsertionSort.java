package com.gold.algorithm.learnblock.sort;

import java.util.Arrays;

/**
 * @author goldhuang
 * @Description: 插入排序
 * 最优复杂度: O(n) - 尾部开始遍历
 * 最差复杂度：O(n^2)
 * 平均复杂度：O(n^2) - 数组的插入复杂度是O(n^2)
 * 稳定排序
 * @date 2021-03-15
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        final int[] ints1 = sort1(ints);
        Arrays.stream(ints1).forEach(System.out::println);
    }

    /**
     * 插入排序
     * 这是第一次学习的时候自己写的
     *
     * @param data 待排序数组
     * @param n    待排序数组长度
     * @return 有序数组
     */
    @Deprecated
    public static int[] sort(int[] data, int n) {
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int insertIndex = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (value < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    insertIndex = j + 1;
                    break;
                }
            }
            data[insertIndex] = value;
        }

        return data;
    }

    public static int[] sort1(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int r = data[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (r < data[j]) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = r;
        }
        return data;
    }

}
