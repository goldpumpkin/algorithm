package com.gold.algorithm.leetcode;

import com.gold.algorithm.jianzhioffer.model.ListNode;

public class ReverseLinkedList_206 {

    /**
     * easy
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }


        return prev;
    }
}
