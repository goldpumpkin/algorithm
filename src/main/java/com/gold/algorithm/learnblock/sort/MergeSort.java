package com.gold.algorithm.learnblock.sort;

/**
 * @author goldhuang
 * @Description: 归并排序
 * 算法思想：采用分治思想，将待排序数组分成多个子数组，将各个子数组排序好后，再进行子数组合并
 * 分析：
 *    最好时间复杂度：O(nlogn)
 *    最差时间复杂度：O(nlogn)
 *    平均时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定排序算法
 * @date 2021-03-16
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        sort(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }

        int q = (start + end) / 2;

        sort(data, start, q);
        sort(data, q + 1, end);
        merge(data, start, q, q + 1, end);
    }

    // todo 哨兵模式简化
    public static void merge(int[] data, int a1Start, int a1End, int a2Start, int a2End) {
        int length = a2End - a1Start + 1;
        int[] tmp = new int[length];

        int index = 0;
        int i = a1Start, j = a2Start;

        while (i <= a1End || j <= a2End) {
            if (i <= a1End && j <= a2End) {
                if (data[i] <= data[j]) {
                    tmp[index++] = data[i];
                    i++;
                } else {
                    tmp[index++] = data[j];
                    j++;
                }
            } else if (j <= a2End) {
                tmp[index++] = data[j];
                j++;
            } else if (i <= a1End) {
                tmp[index++] = data[i];
                i++;
            }
        }

        for (int k = 0; k < tmp.length; k++) {
            data[a1Start++] = tmp[k];
        }
    }
}
