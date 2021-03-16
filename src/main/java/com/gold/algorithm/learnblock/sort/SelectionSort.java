package com.gold.algorithm.learnblock.sort;

/**
 * @author goldhuang
 * @Description: 选择排序
 * 最优复杂度: O(n^2)
 * 最差复杂度：O(n^2)
 * 平均复杂度：O(n^2)
 * 不稳定排序
 * @date 2021-03-15
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        int[] sort = sort(ints);
        for (int o : sort) {
            System.out.println(o);
        }
    }

    public static int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    int a = data[i];
                    data[i] = data[j];
                    data[j] = a;
                }
            }
        }
        return data;
    }
}
