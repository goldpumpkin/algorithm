package com.gold.algorithm.learnblock.heap;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author goldhuang
 * @Description: 堆堆堆
 * @date 2021-04-12
 */
public class Heap {

    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 5, 7, 3, 8, 10};
        int[] numsCopy = {4, 2, 1, 5, 7, 3, 8, 10};

        // 堆化一
        int[] heapify = heapify(nums);
        System.out.println(Arrays.stream(heapify).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        // 堆化二
//        int[] heapify1 = heapify(numsCopy, nums.length - 2);
//        System.out.println(Arrays.stream(heapify1).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        // 排序
        for (int i = nums.length - 1; i > 0; i--) {
            int[] heapifyTmp = heapify(numsCopy, i);

            int max = heapifyTmp[0];
            heapifyTmp[0] = heapifyTmp[i];
            heapifyTmp[i] = max;

        }
        System.out.println(Arrays.stream(numsCopy).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * 堆化
     * 思路：堆化所有拥有子节点的节点
     */
    public static int[] heapify(int[] nums) {

        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapifyForOneNode(nums, i, nums.length - 1);
        }

        return nums;
    }

    /**
     * 堆化
     *
     * @param nums
     * @param lastIndex
     * @return
     */
    public static int[] heapify(int[] nums, int lastIndex) {
        for (int i = lastIndex / 2; i >= 0; i--) {
            heapifyForOneNode(nums, i, lastIndex);
        }

        return nums;
    }

    /**
     * 堆化某个节点
     * 注意：只要发生交换，则需要继续堆化,直到没有子节点
     */
    public static void heapifyForOneNode(int[] nums, int currIndex, int lastIndex) {
        int son1Index = currIndex * 2 + 1;
        int son2Index = currIndex * 2 + 2;

        if (son1Index > lastIndex) {
            return;
        }

        int sonMaxIndex;
        if (son2Index > lastIndex) {
            sonMaxIndex = son1Index;
        } else {
            int son1 = nums[son1Index];
            int son2 = nums[son2Index];

            if (son1 > son2) {
                sonMaxIndex = son1Index;
            } else {
                sonMaxIndex = son2Index;
            }
        }

        compareAndSwap(nums, currIndex, sonMaxIndex);

        heapifyForOneNode(nums, sonMaxIndex, lastIndex);
    }

    /**
     * 比较节点，发生交换
     */
    public static void compareAndSwap(int[] nums, int king, int changer) {
        if (nums[changer] > nums[king]) {
            int tmp = nums[changer];
            nums[changer] = nums[king];
            nums[king] = tmp;
        }
    }

}
