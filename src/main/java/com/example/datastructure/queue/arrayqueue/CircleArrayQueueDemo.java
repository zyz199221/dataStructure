package com.example.datastructure.queue.arrayqueue;

import java.util.Scanner;

/**
 * 文件名：CircleArrayQueueDemo
 * 作 者：Miles zhu
 * 时 间：2019/12/15 12:07
 * -------------------------
 * 功能和描述：
 **/
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arratQueue = new CircleArray(4);
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

class CircleArray {
    //数组的最大容量
    private int maxSize;

    //front指向队列的第一个元素位置
    private int front;
    //rear指向队列的最后一个元素的后一位位置
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];

        //一下两个默认值就是0  可以不写
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满~");
            return;
        }
        //直接将数组加入
        arr[rear] = n;
        //rear往后移动必须 和最大容量取模，不然必然会导致数组越界
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            throw new RuntimeException("队列尾空，不能取数据");
        }

        //因为front是指向的数据的第一个元素的位置，所以获取数据的时候直接根据front的下标获取就可以了
        int value = arr[front];
        //取完数据不要忘记将front的位置往后移动，但是不能直接使用front+1 ；因为这样必然会导致数据越界
        //所以 将front往后移动的方法和rear往后移动的方法是一样的，必须根据数组的maxSize对其进行取模
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%s]=%s\n", i % maxSize, arr[i % maxSize]);
        }
    }

    private int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空~");
            throw new RuntimeException("队列为空，无法获取头数据");
        }
        return arr[front];
    }
}
