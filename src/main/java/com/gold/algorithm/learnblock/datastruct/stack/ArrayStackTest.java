package com.gold.algorithm.learnblock.datastruct.stack;


/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-15
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("1");
        arrayStack.push(2);

        System.out.println(arrayStack);

        Object pop = arrayStack.pop();
        System.out.println(pop);
        arrayStack.pop();


        // 扩容测试
        ArrayStackPro arrayStackPro = new ArrayStackPro(2);
        System.out.println(arrayStackPro.size());

        arrayStackPro.push("1");
        arrayStackPro.push(2);
        arrayStackPro.push(3);

        System.out.println(arrayStackPro.size());

    }
}
