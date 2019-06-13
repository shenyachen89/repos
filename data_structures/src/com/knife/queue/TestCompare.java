package com.knife.queue;

import java.util.Random;

public class TestCompare {

    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需时间，单位：秒
     *
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * ArrayQueue time: 0.048778655 s
     * LoopQueue time: 0.00269311 s
     * @param args
     */
    public static void main(String[] args) {
        int opCount = 10000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue time: "+time1+" s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue time: "+time2+" s");

    }
}
