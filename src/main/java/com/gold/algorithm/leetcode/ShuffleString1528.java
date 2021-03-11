package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description: {1528}https://leetcode-cn.com/problems/shuffle-string/
 * @date 2021-03-11
 */
public class ShuffleString1528 {

    public static void main(String[] args) {
        String s = "aiohn";
        int[] ints = {3,1,4,2,0};
        restoreString1(s, ints);
    }

    public String restoreString(String s, int[] indices) {
        if (s == null || indices == null) {
            return null;
        }

        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }

        return String.valueOf(result);
    }


    public static String restoreString1(String s, int[] indices) {
        if (s == null || indices == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != indices[i]) {
                int targetIndex = indices[i];
                char tmp = chars[targetIndex];
                chars[targetIndex] = chars[i];
                chars[i] = tmp;

                int tmp2 = indices[targetIndex];
                indices[targetIndex] = indices[i];
                indices[i] = tmp2;

                // 由于替换完成后，并不能确定，再继续执行遍历会将剩余的元素完全替换，则重置便利游标
                // 举例： "aiohn" {3,1,4,2,0}
                i=0;
            }
        }

        return String.valueOf(chars);
    }


}
