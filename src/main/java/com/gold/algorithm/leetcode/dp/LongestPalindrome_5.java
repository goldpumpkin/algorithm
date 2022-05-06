package com.gold.algorithm.leetcode.dp;

/**
 * 最长回文子串
 */
public class LongestPalindrome_5 {

    /**
     * 思路:
     * 1. 遍历字符串，找出 以char[i]为头的回文子串 --- 成功
     * 2. 假设回文子串最大长度，为 n, n-1 .... --- 成功
     */
    public static String longestPalindrome(String s) {
        final char[] chars = s.toCharArray();

        for (int max = chars.length - 1; max >= 1; max--) {
            for (int index = 0; index < chars.length - max; index++) {
                int st = index;
                int ed = index + max;

                while (chars[st] == chars[ed]) {
                    st++;
                    ed--;
                    if (st == ed || (st - ed == 1)) {
                        return s.substring(index, index + max + 1);
                    }
                }
            }
        }

        return s.substring(0, 1);
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome1(s));
    }

    public static String longestPalindrome1(String s) {
        final char[] chars = s.toCharArray();
        String max = s.substring(0, 1);

        for (int i = 0; i <= chars.length - 2; i++) {
            if (max.length() >= (chars.length - i + 1)) {
                break;
            }
            for (int end = chars.length - 1; end > i; end--) {

                int st = i;
                int ed = end;

                while (chars[st] == chars[ed]) {
                    if (st == ed || (ed - st == 1)) {
                        if (end - i + 1 > max.length()) {
                            max = s.substring(i, end + 1);
                        }
                        break;
                    }
                    st++;
                    ed--;
                }

            }
        }

        return max;
    }
}
