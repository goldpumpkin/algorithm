package com.gold.algorithm.learnblock.search;

/**
 * @author goldhuang
 * @Description: 二分查找
 *  时间复杂度：O(logn)
 *
 * @date 2021-03-18
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 4, 5, 7, 8, 10, 12, 14, 16, 17, 19, 22, 33, 44, 55, 66, 68};

        System.out.println(search(nums, 8));
        System.out.println(search(nums, 11));


        System.out.println(search(nums, 0, nums.length - 1, 8));
        System.out.println(search(nums, 0, nums.length - 1, 11));
    }

    /**
     * 二分查找 非递归
     * 实现注意：
     *  1. 循环条件
     *  2. mid 的计算
     *  3. left right 的赋值
     */
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;

        while (left <= right) {
            int num = nums[mid];
            if (num > target) {
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            } else {
                return mid;
            }

            mid = left + (right - left) / 2;
        }

        return -1;
    }

    /**
     * 二分查找 递归
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int num = nums[mid];

        if (num == target) {
            return mid;
        } else if (num < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }

        return search(nums, left, right, target);
    }
}
