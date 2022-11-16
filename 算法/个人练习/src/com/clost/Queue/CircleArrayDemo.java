package com.clost.Queue;

import java.util.Scanner;

/**
 * @author clost
 * @date 2022/9/3 11:32
 */
public class CircleArrayDemo {

    public static void main(String[] args) {
        //创建队列

        CircleArray circleArray = new CircleArray(4);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean flag = true;
        while (flag) {
            System.out.println("1.添加数据进队列");
            System.out.println("2.取出数据");
            System.out.println("3.显示队列中的所有数据");
            System.out.println("4.显示队列头数据");
            System.out.println("5.退出");
            System.out.println("请输选择你的操作");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("请输入你要添加的数据");
                    circleArray.addQueue(scanner.nextInt());
                }
                case 2 -> System.out.println(circleArray.getQueue());
                case 3 -> circleArray.showQueue();
                case 4 -> circleArray.headQueue();
                case 5 -> flag = false;
                default -> System.out.println("输入有误，请重新输入");
            }
        }
    }
}


class CircleArray {
    private int MaxSize;//数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //模拟队列的数组

    public CircleArray(int arrMaxsize) {
        MaxSize = arrMaxsize;
        arr = new int[MaxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1 + MaxSize) % MaxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        //判断队列是否为满
        if (isFull()) {
            System.out.println("队列满了,无法添加数组");
            return;
        }
        arr[rear++] = n;
        rear = rear % MaxSize;

    }

    //取出数组
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数组！");
        }

        int value = arr[front];
        front = (front + 1) % MaxSize;
        return value;
    }

    //返回当前队列有效数据的个数
    public int size() {
        return (rear + MaxSize - front) % MaxSize;
    }


    //显示队列的所有数据
    public void showQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法遍历");

        }

        for (int i = front; i < size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % MaxSize, arr[i % MaxSize]);
        }


    }

    //显示队列的头部

    public void headQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        System.out.println("队列的头部为:" + arr[front]);
    }


}
