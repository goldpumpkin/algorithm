package com.gold.algorithm.leetcode;

import com.gold.algorithm.model.ListNode;

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

    /**
     * 回文 - 单向链表
     * 可以看看别人的代码：https://github.com/andavid/leetcode-java/blob/master/note/234/README.md
     * 比我的简单
     */
    public static boolean isPalindrome(ListNode<String> head) {
        if (head == null) {
            return false;
        }

        if (head.getNext() == null) {
            return true;
        }

        ListNode<String> prev = null;
        ListNode<String> slow = head;
        ListNode<String> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();

            final ListNode<String> next = slow.getNext();
            slow.setNext(prev);
            prev = slow;
            slow = next;
        }

        if (fast.getNext() != null && prev != null) {
            slow.setNext(prev);
            prev = slow;
            slow = slow.getNext();
        }

        if (prev == null) {
            prev = head;
            slow = slow.getNext();
        }

        while (prev != null && slow.getNext() != null) {
            final String d1 = prev.getData();
            final String d2 = slow.getNext().getData();
            if (!d1.equals(d2)) {
                return false;
            }

            prev = prev.getNext();
            slow = slow.getNext();
        }

        return true;
    }

    public static void main(String[] args) {
        final ListNode<String> palindrome = ListNode.buildPalindrome();
        System.out.println(palindrome);

        final boolean p = isPalindrome(palindrome);
        System.out.println(p);

        final boolean p2 = isPalindrome2(palindrome);
        System.out.println(p2);
    }

    /**
     * 区别于上一个方法：指针初始化时，已经开始走了一步
     */
    public static boolean isPalindrome2(ListNode<String> head) {
        if (head == null) {
            return false;
        }

        if (head.getNext() == null) {
            return true;
        }

        ListNode<String> prev = head;
        ListNode<String> slow = head;
        ListNode<String> fast = head.getNext();

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();

            final ListNode<String> next = slow.getNext();
            slow.setNext(prev);
            prev = slow;
            slow = next;
        }

        if (fast.getNext() != null) {
            slow.setNext(prev);
            prev = slow;
            slow = slow.getNext();
        }

        while (prev != null && slow.getNext() != null) {
            final String d1 = prev.getData();
            final String d2 = slow.getNext().getData();
            if (!d1.equals(d2)) {
                return false;
            }

            prev = prev.getNext();
            slow = slow.getNext();
        }

        return true;
    }

}
