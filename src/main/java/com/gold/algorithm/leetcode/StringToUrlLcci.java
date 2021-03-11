package com.gold.algorithm.leetcode;

/**
 * @author goldhuang
 * @Description:  {URL化}https://leetcode-cn.com/problems/string-to-url-lcci/submissions/
 * 注意理解题意：
 * + 使用字符数组
 * + 在字符数组操作
 * + 字符串所给长度够用
 * @date 2021-03-11
 */
public class StringToUrlLcci {

    /**
     * 我的第一次解法 - 超时 Fail
     * 反思：没有理解题目的意思
     *
     * @param s
     * @param length
     * @return
     */
    public String replaceSpaces(String s, int length) {
        StringBuilder result = new StringBuilder();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if (charArr[i] == ' ') {
                result.append("%20");
            } else {
                result.append(charArr[i]);
            }
        }
        return result.toString();
    }

    /**
     * 在数组上操作，最后进行截断
     */
    public String replaceSpaces1(String s, int length) {
        char[] chars = s.toCharArray();
        int i = length - 1;
        int j = chars.length - 1;

        while (i >= 0) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            } else {
                chars[j--] = chars[i];
            }
            --i;
        }

        return String.valueOf(chars, j + 1, chars.length - 1 - j);
    }

    /**
     * 内存占用比较多
     */
    public String replaceSpace2(String s, int length) {
        char[] chars = s.toCharArray();
        char[] result = new char[s.length()];
        int newIndex = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                result[newIndex++] = '%';
                result[newIndex++] = '2';
                result[newIndex++] = '0';
            }else {
                result[newIndex++] = chars[i];
            }
        }
        return String.valueOf(result, 0, newIndex);
    }

    /**
     * 减少了一次字符数组的copy
     * @param s
     * @param length
     * @return
     */
    public String replaceSpace3(String s, int length) {
        char[] result = new char[s.length()];
        int newIndex = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                result[newIndex++] = '%';
                result[newIndex++] = '2';
                result[newIndex++] = '0';
            }else {
                result[newIndex++] = s.charAt(i);
            }
        }
        return String.valueOf(result, 0, newIndex);
    }

    public String replaceSpace4(String s, int length) {
        char[] result = new char[s.length()];
        int newIndex = 0;
        int i = 0;
        while (i < length){
            if (s.charAt(i) == ' ') {
                result[newIndex++] = '%';
                result[newIndex++] = '2';
                result[newIndex++] = '0';
            }else {
                result[newIndex++] = s.charAt(i);
            }

            ++i;
        }
        return String.valueOf(result, 0, newIndex);
    }
}
