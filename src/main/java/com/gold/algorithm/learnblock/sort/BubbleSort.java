package com.gold.algorithm.learnblock.sort;

/**
 * @author goldhuang
 * @Description: 冒泡排序
 * 最优复杂度: O(n)
 * 最差复杂度：O(n^2)
 * 平均复杂度：O(n^2) --- 逆序度 = 满虚度 - 现在的有序度 这里的逆序度就是要交换的次数
 *    满有虚度 - n*(n-1)/2
 *    现有虚度：
 *      最好情况下：n*(n-1)/2
 *      最坏情况下：0
 * 稳定排序
 * @date 2021-03-15
 */
public class BubbleSort {

    public static int[]  sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            boolean flag = true;
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = false;
                }
            }

            if (flag) {
                return data;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] ints = {3, 4, 1, 9, 10, 4, 2, 1};
        int[] sort = sort(ints);
        for (int i : sort) {
            System.out.println(i);

        }
    }
}

