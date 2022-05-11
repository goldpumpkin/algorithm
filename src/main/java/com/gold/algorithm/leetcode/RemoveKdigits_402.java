package com.gold.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKdigits_402 {

    /**
     * mine
     * 思路：移除k个，相当于保留n个
     * 第一步：在 0到n-1 index 之间，找到最小的数字
     * 第二步：如果位数还有剩余，则找出第二小的数字，依次类推
     */
    public static String removeKdigits(String num, int k) {
        if (num == null) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }

        final char[] chars = num.toCharArray();
        int remain = chars.length - k;

        final char[] result = new char[remain];

        int start = 0;
        int end;
        int minIndex;
        for (int i = remain; i > 0; i--) {
            end = chars.length - i;
            minIndex = findMinIndex(start, end, chars);
            result[remain - i] = chars[minIndex];
            start = minIndex + 1;
        }

        boolean flag = true;
        final StringBuilder stringBuffer = new StringBuilder();
        for (char c : result) {
            if (c == '0' && flag) {
                continue;
            } else {
                flag = false;
            }

            stringBuffer.append(c);
        }

        return "".equals(stringBuffer.toString()) ? "0" : stringBuffer.toString();
    }

    private static int findMinIndex(int startIndex, int endIndex, char[] chars) {
        if (startIndex == endIndex) {
            return startIndex;
        }

        int minIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (chars[i] < chars[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        final String s = "1234567890";
        final int k = 9;
        final String s1 = removeKdigits1(s, k);
        System.out.println(s1);
    }


    /**
     * 看答案
     * 解法思想：移除 k 位，保证整个序列是单调递增的
     * 栈中属于高位元素
     */
    public static String removeKdigits1(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }

        final Deque<Character> deque = new ArrayDeque<>(num.length());

        final char[] chars = num.toCharArray();
        for (char c : chars) {
            while (!deque.isEmpty() && c < deque.peek() && k > 0) {
                deque.pop();
                k--;
            }

            if (!(c == '0' && deque.isEmpty())) {
                deque.push(c);
            }
        }

        while (k > 0 && !deque.isEmpty()) {
            deque.pop();
            k--;
        }

        final StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            final Character character = deque.pollLast();
            sb.append(character);
        }

        return "".equals(sb.toString()) ? "0" : sb.toString();
    }


}
