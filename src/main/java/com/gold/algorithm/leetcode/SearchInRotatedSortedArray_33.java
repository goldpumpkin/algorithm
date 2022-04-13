package com.gold.algorithm.leetcode;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray_33 {

    public static int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (l == (r - 1)) {
                break;
            }
            int mid = l + (r - l) / 2;
            if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }

        int ls, le, rs, re;
        if (nums[l] > nums[r]) {
            ls = 0;
            le = l;
            rs = r;
            re = nums.length - 1;
        } else {
            ls = rs = 0;
            le = re = nums.length - 1;
        }

        int s, e;
        if (target >= nums[ls] && target <= nums[le]) {
            s = ls;
            e = le;
        } else if (target >= nums[rs] && target <= nums[re]) {
            s = rs;
            e = re;
        } else {
            return -1;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] d = {3,1};
        final int search = search(d, 3);
        System.out.println(search);
    }

}
