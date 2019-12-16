package com.example.datastructure.queue.arrayqueue;

import java.util.Optional;
import java.util.Scanner;

/**
 * 文件名：ArrayQueueDemo
 * 作 者：Miles zhu
 * 时 间：2019/12/14 21:00
 * -------------------------
 * 功能和描述：使用数组模拟队列
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArratQueue arratQueue = new ArratQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s：显示队列");
            System.out.println("e：退出程序");
            System.out.println("a：添加数据到队列");
            System.out.println("g：从队列里取出数据");
            System.out.println("h：查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arratQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    arratQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int value1 = arratQueue.getQueue();
                        System.out.println("取出的数为：" + value1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = arratQueue.headQueue();
                        System.out.println("队列头的数据是：" + i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }


}

class ArratQueue {
    //表示数组的最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据，模拟队列
    private int[] arr;

    //创建队列构造器
    public ArratQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        //指向队列头部，在没有任何元素的情况下，是-1
        this.front = -1;
        //指向队列尾的数据（即队列最后的一个数据）
        this.rear = -1;
    }

    //判断队列是否满了
    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    //添加元素到队列
    public void addQueue(int n) {
        if (isFull()) {
            Optional.of("队列已满~").ifPresent(System.out::println);
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            Optional.of("队列尾空~").ifPresent(System.out::println);
            throw new RuntimeException("队列为空~");
        }
        front++;
        return arr[front];
    }

    //显示所有数据
    public void showQueue() {
        if (isEmpty()) {
            Optional.of("队列尾空~").ifPresent(System.out::println);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%s]=%s\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            Optional.of("队列为空").ifPresent(System.out::println);
            throw new RuntimeException("队列为空，没有数据~");
        }
        return arr[front + 1];
    }
}
