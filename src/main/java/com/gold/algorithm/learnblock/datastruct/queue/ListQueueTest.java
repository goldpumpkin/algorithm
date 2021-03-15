package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
public class ListQueueTest {

    public static void main(String[] args) {
        ListQueue listQueue = new ListQueue(2);
        listQueue.enqueue("1");
        listQueue.enqueue("2");

        System.out.println(listQueue.enqueue("3"));
        System.out.println(listQueue.dequeue());

        System.out.println(listQueue.enqueue("3"));
        System.out.println(listQueue.dequeue());
    }
}
