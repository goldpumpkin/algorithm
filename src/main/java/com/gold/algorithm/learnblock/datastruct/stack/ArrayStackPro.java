package com.gold.algorithm.learnblock.datastruct.stack;

/**
 * @author goldhuang
 * @Description: 顺序栈 - 支持动态扩容
 * @date 2021-03-15
 */
public class ArrayStackPro {

    private Object[] data;
    private int capacity;
    private int size;

    public ArrayStackPro(int capacity) {
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean push(Object o) {
        if (size == capacity) {
            // 扩容
            capacity = capacity * 2;
            Object[] newData = new Object[capacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
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

    public int size() {
        return this.size;
    }

}
