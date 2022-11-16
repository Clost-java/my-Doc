package com.clost.stack;

/**
 * @author clost
 * @date 2022/9/11 8:54
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.list();
    }


}


class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;  //数组模拟栈
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈满
    public boolean isFull() {

        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int values) {
        if (isFull()) {
            System.out.println("栈满!");
            return;
        }
        stack[++top] = values;


    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //遍历栈

    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
        }

        while(top > -1){
            System.out.println(stack[top--]);
        }

    }


}
