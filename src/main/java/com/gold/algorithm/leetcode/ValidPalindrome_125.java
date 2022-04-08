package com.gold.algorithm.leetcode;

public class ValidPalindrome_125 {

    /**
     * https://leetcode.com/problems/valid-palindrome/
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) - Character.toLowerCase(s.charAt(j)) != 0) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

}
