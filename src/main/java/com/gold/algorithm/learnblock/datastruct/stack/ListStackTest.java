package com.gold.algorithm.learnblock.datastruct.stack;


/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
public class ListStackTest {

    public static void main(String[] args) {
        ListStack listStack = new ListStack(2);
        System.out.println(listStack.isEmpty());

        listStack.push("1");
        listStack.push(2);

        System.out.println(listStack.isFull());

        System.out.println(listStack.pop());
        System.out.println(listStack.pop());

        System.out.println(listStack.isEmpty());

    }
}
