package com.gold.algorithm.learnblock.search;

/**
 * @author goldhuang
 * @Description: 二分法变形：查找 最后一个值 小于等于 给定值的元素
 * @date 2021-03-18
 */
public class Question_FindLastEqualOrGreaterThan {

    public static void main(String[] args) {
        int[] ints = {2, 4, 6, 9, 10, 10, 10, 12, 15, 16, 16, 16, 17, 20};

        System.out.println(search(ints, 8));
        System.out.println(search(ints, 10));
        System.out.println(search(ints, 16));

    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;

        while (l <= r) {
            if (nums[mid] <= target) {
                if (mid == nums.length - 1) {
                    return mid;
                }

                if (nums[mid + 1] > target) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }

            mid = l + (r - l) / 2;
        }

        return -1;
    }
}
