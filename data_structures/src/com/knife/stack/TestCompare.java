package com.knife.stack;

import java.util.Random;

public class TestCompare {
    /**
     * 测试使用stack运行opCount个push和pop操作所需时间，单位：秒
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * ArrayStack time: 0.015851969 s
     * LinkedListStack time: 0.012444829 s
     * @param args
     */
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time: "+time1+" s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack time: "+time2+" s");
    }
}
