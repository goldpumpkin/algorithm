package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description: {在排序数组中查找数字 I}https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/submissions/
 * *      核心算法：二分法
 * @date 2021-03-12
 */
public class FindNumberCount_Offer53II {

    public static void main(String[] args) {
        int[] i = {1};
        search3(i, 1);

    }

    /**
     * 解法一：二分法
     * 错了2次
     * 时间复杂度：O(logn)
     * 思路：
     * 1. 先找到一个目标数
     * 2. 从找到的index，向两边开始扩散寻找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                l = m;
                break;
            } else {
                r = m;
            }
        }

        if (nums[l] != target) {
            return 0;
        }

        int count = 1;
        int i = 1;
        while (l - i >= 0 || l + i <= nums.length - 1) {

            boolean leftTarget = l - i >= 0 && nums[l - i] == target;
            if (leftTarget) {
                count++;
            }

            boolean rightTarget = l + i <= nums.length - 1 && nums[l + i] == target;
            if (rightTarget) {
                count++;
            }

            if (!leftTarget && !rightTarget) {
                break;
            }

            i++;

        }

        return count;
    }

    /**
     * 解法二：时间复杂度 O(n)
     */
    public int search1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                if (count > 0) {
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 解法三
     * 低级错误错了一次
     * 思路：
     * 和解法一类似
     * 1. 先找到目标数在数组的起始位置
     * 2. 从找到的位置进行计数
     */
    public static int search3(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] == target) {
                if (m == 0) {
                    break;
                }

                if (nums[m - 1] < target) {
                    l = m;
                    break;
                } else {
                    r = m;
                }
            } else {
                r = m;
            }
        }

        int count = 0;
        for (int i = l; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                if (count > 0) {
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 解法四
     * 网友提供
     * 相比我的，写法较简单
     * 核心：二分法
     * 注意: 不断缩小右边界，我的判断比较细致但是复杂
     */
    public int search4(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid;
            if (nums[mid] < target)
                left = mid + 1;
        }
        while (left < nums.length && nums[left++] == target)
            count++;
        return count;
    }

}
