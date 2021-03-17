package com.gold.algorithm.learnblock.sort;

/**
 * @author goldhuang
 * @Description: 快速排序
 * 算法思想：分治思想，把 pivot（分区点）放到正确的位置上，并分区
 * 分析：
 * 最好时间复杂度：O(nlogn)
 * 最差时间复杂度：O(n^2)
 * 平均时间复杂度：O(nlogn)
 * 空间复杂度：O(1) 原地算法
 * 稳定性：不稳定排序算法
 * @date 2021-03-16
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        sort(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        // 找到 pivot
        int pivotIndex = findPivot(data, start, end);

        // 分组sort
        sort(data, start, pivotIndex - 1);
        sort(data, pivotIndex + 1, end);
    }

    /**
     * 两个指针 i-小于 pivot 的元素并做替换 j-指向大于等于 pivot 的元素
     */
    public static int findPivot(int[] data, int start, int end) {
        int pivot = data[end];
        int j = start;

        // 注意顺序
        for (int i = start; i < end; i++) {
            // 1. 判断和pivot的大小并做替换
            if (data[i] < pivot && i != j) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;

                j++;
            }

            // 2. 指针j的移动控制
            if (data[j] <= pivot) {
                j++;
            }
        }

        // swap j end
        data[end] = data[j];
        data[j] = pivot;

        return j;
    }
}
