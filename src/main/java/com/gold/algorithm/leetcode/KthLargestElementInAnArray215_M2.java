package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description: {最K大的数}https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 利用选择排序思想
 * @date 2021-03-17
 */
public class KthLargestElementInAnArray215_M2 {

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 1, 10, 2, 9, 3};
        KthLargestElementInAnArray215_M2 kthLargestElementInAnArray215 = new KthLargestElementInAnArray215_M2();
        for (int i = 1; i <= ints.length; i++) {
            System.out.println("第" + i +"大的数是：" + kthLargestElementInAnArray215.findKthLargest(ints, i));
        }
    }

    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums[k - 1];
    }


}
