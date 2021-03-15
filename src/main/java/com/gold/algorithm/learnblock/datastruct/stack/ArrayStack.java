package com.gold.algorithm.learnblock.datastruct.stack;

/**
 * @author goldhuang
 * @Description: 顺序栈 - 不支持动态扩容
 * @date 2021-03-15
 */
public class ArrayStack {

    private Object[] data;
    private int capacity;
    private int size;

    public ArrayStack(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean push(Object o) {
        if (size == capacity) {
            throw new RuntimeException("the container is full");
        }
        data[size++] = o;
        return true;
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException("the container is empty");
        }
        Object result = data[--size];
        return result;
    }

}
