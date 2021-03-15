package com.gold.algorithm.learnblock.datastruct.queue;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
public class ArrayQueueTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("!");
        arrayQueue.enqueue("2");

        System.out.println(arrayQueue.enqueue("3"));
        System.out.println(arrayQueue.dequeue());

        System.out.println(arrayQueue.enqueue("$"));
        System.out.println(arrayQueue.dequeue());
    }
}
