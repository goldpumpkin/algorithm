package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description: {11.盛最多水的容器}https://leetcode-cn.com/problems/container-with-most-water/
 * @date 2021-03-12
 */
public class ContainerWithMostWater11 {

    /**
     * 思路：
     * 1. 问题是 找出最大的面积
     * 2. 面积 = min(h1,h2) * (j-i)
     * 3. 以宽度最大为基准，只有移动高度较小的边，才有可能使得面积变大
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
