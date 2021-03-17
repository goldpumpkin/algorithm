package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description: {最K大的数}https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 思想：利用「快速排序」 pivot分区点分区思想
 * @date 2021-03-17
 */
public class KthLargestElementInAnArray215 {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        KthLargestElementInAnArray215 kthLargestElementInAnArray215 = new KthLargestElementInAnArray215();
        for (int i = 1; i <= ints.length; i++) {
            System.out.println("第" + i +"大的数是：" + kthLargestElementInAnArray215.findKthLargest(ints, i));
        }
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        int index = find(nums, 0, nums.length - 1, k);
        return index == -1 ? index : nums[index];
    }

    public int find(int[] nums, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int result;
        int i = partition(nums, start, end);
        if (i == k - 1) {
            result = i;
        } else if (i > k - 1) {
            result = find(nums, 0, i - 1, k);
        } else {
            result = find(nums, i + 1, end, k);
        }

        return result;
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int j = start;

        for (int i = start; i < end; i++) {
            if (nums[i] > pivot && i != j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                j++;
            }

            if (nums[j] >= pivot) {
                j++;
            }
        }

        nums[end] = nums[j];
        nums[j] = pivot;

        return j;
    }

}
