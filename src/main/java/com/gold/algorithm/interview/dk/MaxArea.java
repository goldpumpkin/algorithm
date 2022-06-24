package com.gold.algorithm.interview.dk;

/**
 * 变形题：https://leetcode.cn/problems/container-with-most-water/
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] i = {10,9,8,7,6,5,4,3,2,1};
        System.out.println(maxArea(i));
    }

    public static int maxArea(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int maxArea = 0;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int n = nums[i];
            int m = nums[j];

            int currentArea = Math.min(n, m) * (j - i);
            maxArea = Math.max(maxArea, currentArea);

            if (n < m) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

}
