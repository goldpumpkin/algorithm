package com.gold.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author goldhuang
 * @Description: {每日温度}https://leetcode-cn.com/problems/daily-temperatures/
 * 思路: 注意关键词：从当前该位开始 第一个大于 本数的 index
 * 倒序遍历
 * @date 2021-03-29
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] dailyTemperatures(int[] tData) {
        int[] result = new int[tData.length];

        for (int i = tData.length - 1; i >= 0; i--) {
            if (i == tData.length - 1) {
                result[i] = 0;
                continue;
            }

            if (tData[i + 1] > tData[i]) {
                result[i] = 1;
            } else {
                int n = result[i + 1];
                int cu = i + 1;

                if (n == 0) {
                    result[i] = 0;
                } else {
                    while (n > 0) {
                        int next = cu + n;
                        int nextNum = tData[next];
                        if (nextNum > tData[i]) {
                            n = next - i;
                            break;
                        }

                        cu = next;
                        n = result[cu];
                    }

                    result[i] = n;
                }
            }
        }

        return result;
    }

}
