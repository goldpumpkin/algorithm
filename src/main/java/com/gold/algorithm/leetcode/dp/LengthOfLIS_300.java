package com.gold.algorithm.leetcode.dp;

public class LengthOfLIS_300 {

    /**
     * 没想到啊，想到了一半的思路 Damn
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] status = new int[nums.length];
        status[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            status[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    status[i] = Math.max(status[i], status[j] + 1);
                }
            }

            max = Math.max(max, status[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(lengthOfLIS(nums));
    }

}
