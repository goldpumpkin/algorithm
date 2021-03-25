package com.gold.algorithm.jianzhioffer;

import com.gold.algorithm.jianzhioffer.model.ListNode;

/**
 * @author goldhuang
 * @Description: {合并两个单向递增链表} https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @date 2021-03-25
 */
public class MergeTwoList {

    public static void main(String[] args) {
        ListNode l = new ListNode(6);
        ListNode l2 = new ListNode(1);
        ListNode listNode = mergeTwoList(l, l2);
        System.out.println(listNode);

    }


    /**
     * 注意点：
     *   1. 循环中 l1 l2的赋值
     *   2. 保存头结点输出
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = null;
        ListNode prev = null;

        while (l1 != null || l2 != null) {
            ListNode current;
            if (l1 != null && l2 != null) {
                if (l1.getVal() <= l2.getVal()) {
                    current = new ListNode(l1.getVal());
                    l1 = l1.getNext();
                } else {
                    current = new ListNode(l2.getVal());
                    l2 = l2.getNext();
                }
            } else if (l1 != null) {
                current = new ListNode(l1.getVal());
                l1 = l1.getNext();
            } else {
                current = new ListNode(l2.getVal());
                l2 = l2.getNext();
            }

            if (head ==  null) {
                head = current;
                prev = current;
            } else {
                prev.setNext(current);
                prev = current;
            }
        }

        return head;
    }
}
