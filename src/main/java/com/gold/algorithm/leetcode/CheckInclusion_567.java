package com.gold.algorithm.leetcode;

import java.util.Arrays;

/**
 * 思想：滑动窗口
 * api: Arrays.equals(c1, c2);
 */
public class CheckInclusion_567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusionUpgrade(s1, s2));


        String s11 = "abc";
        String s22 = "defgcbax";
        System.out.println(checkInclusionUpgrade(s11, s22));
    }

    public boolean checkInclusion(String s1, String s2) {
        final int n = s1.length();
        final int m = s2.length();
        if (m < n) {
            return false;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < n; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(c1, c2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;

    }

    /**
     * 判断字符串1，比如abc的各种不同方式的排序是否存在于字符串2中，比如defgcbax，如果不存在，返回-1，如果存在，返回字符串1子序在字符串2中的最小index；
     */
    public static int checkInclusionUpgrade(String s1, String s2) {
        final int n = s1.length();
        final int m = s2.length();
        if (m < n) {
            return -1;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < n; i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(c1, c2)) {
            return 0;
        }

        for (int i = n; i < m; i++) {
            c2[s2.charAt(i) - 'a']++;
            c2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(c1, c2)) {
                return i - n + 1;
            }
        }

        return -1;
    }

}
