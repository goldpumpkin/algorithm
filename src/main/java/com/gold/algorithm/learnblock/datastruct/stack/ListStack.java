package com.gold.algorithm.learnblock.datastruct.stack;

import com.gold.algorithm.learnblock.list.Node;

/**
 * @author goldhuang
 * @Description: 链式栈 支持动态扩容
 * @date 2021-03-15
 */
public class ListStack {

    private Node data;
    private int capacity;
    private int size;

    public ListStack(int capacity) {
        this.data = null;
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean push(Object o) {
        if (size == capacity) {
            throw new RuntimeException("the container is full");
        }
        data = new Node(o, data);
        size++;
        return true;
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException("the container is empty");
        }

        Object result = data.getData();
        data = data.getNext();
        size--;
        return result;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
