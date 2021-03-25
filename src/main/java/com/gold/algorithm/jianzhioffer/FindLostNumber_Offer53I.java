package com.gold.algorithm.jianzhioffer;

/**
 * @author goldhuang
 * @Description: {0~n-1}中缺失的数字，https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/submissions/
 * 这个题目太绕了 给一个数组，长度为n, 数组中的数字的范围是 0~n, 其中有一个数字不在数组当中，数组是递增排序的
 *      核心算法：二分法
 * @date 2021-03-11
 */
public class FindLostNumber_Offer53I {

    /**
     * 此方法没有用到题目中 "有序" 关键字
     * 时间复杂度 O(n)
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 二分法解法：
     *  试了6次 才把代码调试好
     *  反思：mid 节点的计算 和 跳出逻辑
     *  边界需要考虑很多
     *
     * 时间复杂度：O(logn)
     */
    public int missingNumber1(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) {
            return 0;
        }

        if (nums[nums.length - 1] == nums.length - 1) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;
        int mid = (r + l) / 2;

        while (l != r) {
            // 相等：缺失的数字在 mid 之后
            if (nums[mid] == mid) {
                // 判断一次 是否下一个是否就是缺失的数字
                if (nums[mid + 1] != mid + 1) {
                    return mid + 1;
                } else {
                    l = mid;
                }
            } else if (nums[mid] > mid) {
                if (mid - 1 < 0) {
                    return 0;
                }
                if (nums[mid - 1] == mid - 1) {
                    return nums[mid] - 1;
                } else {
                    r = mid;
                }
            } else {
                // do nothing
            }

            mid = (r + l) / 2;
        }

        return nums.length;
    }

    /**
     * 二分法：参考网友的做法
     *
     * 注意的点：
     *  计算 m 的方法，总数为偶数时候落到的较小的 index
     *  二分法的循环跳出规则, l 和 r 重合
     */
    public int missingNumber2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] != m) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (l == nums.length - 1 && nums[l] == l) ? l + 1 : l;
    }
}
