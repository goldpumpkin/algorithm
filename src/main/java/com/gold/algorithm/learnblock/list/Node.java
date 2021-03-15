package com.gold.algorithm.learnblock.list;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
@Data
@Builder
@NoArgsConstructor
public class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}
