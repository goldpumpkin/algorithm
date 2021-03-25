package com.gold.algorithm.jianzhioffer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-25
 */
@Data
@NoArgsConstructor
public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
