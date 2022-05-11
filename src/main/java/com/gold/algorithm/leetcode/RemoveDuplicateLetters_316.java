package com.gold.algorithm.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveDuplicateLetters_316 {

    /**
     * 单调栈
     */
    public static String removeDuplicateLetters(String s) {
        final Map<Character, Integer> count = new HashMap<>();
        final char[] chars = s.toCharArray();

        for (char c : chars) {
            final Integer curr = count.get(c);
            final Integer n = curr == null ? 0 : curr + 1;
            count.put(c, n);
        }

        final Deque<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && count.get(stack.peek()) > 0) {
                    final Character peek = stack.peek();
                    final Integer current = count.get(peek);
                    stack.pop();
                    count.put(peek, current - 1);
                }

                stack.push(c);
            } else {
                count.put(c, count.get(c) - 1);
            }
        }

        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            final Character character = stack.pollLast();
            sb.append(character);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        final String s = "bcabc";
        final String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }

}
