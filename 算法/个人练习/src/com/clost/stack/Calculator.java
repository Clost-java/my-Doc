package com.clost.stack;

/**
 * @author clost
 * @date 2022/11/14 18:16
 */
public class Calculator {
    public static void main(String[] args) {


        String expression = "91*91+1-4";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operaStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int opera = 0 ;
        int res = 0;
        char ch = ' ';
        String keyNum = "";

        while(true){
            ch = expression.substring(index,index+1).charAt(0);
            //判断是符号还是数字
            if(operaStack.isOpera(ch)){
                //判断符号栈是否为空
                if(!operaStack.isEmpty()){
                    //不为空比较当前符号与符号栈顶符号的优先级，反之入栈
                    if(operaStack.priority(operaStack.peak()) >= operaStack.priority(ch)){
                        //优先级小于等于符号栈顶元素时，数字栈中pop出两个数,符号栈pop出一个符号进行运算，
                        // 将结果push到数字栈,将当前符号push到符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        opera = operaStack.pop();
                        res = numStack.cal(num2,num1,opera);
                        numStack.push(res);
                        operaStack.push(ch);
                    }
                    else {
                        //优先级大于符号栈顶元素时
                        operaStack.push(ch);
                    }
                }else{
                    operaStack.push(ch);
                }
            }else{
              //数字处理多位数

                keyNum += ch;
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keyNum));
                }else {

                    if (numStack.isOpera(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keyNum));
                        keyNum = "";
                    }
                }



            }

            index++;
            if(index >= expression.length()){
                break;
            }
        }

        while (true){
            if(operaStack.isEmpty()){
                break;
            }
        num1 = numStack.pop();
        num2 = numStack.pop();
        opera = operaStack.pop();
        res = numStack.cal(num2,num1,opera);
        numStack.push(res);
        }

        System.out.println(numStack.pop());





    }
}


class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;  //数组模拟栈
    private int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判断栈满
    public boolean isFull() {

        return top == maxSize - 1;
    }

    public int peak(){
        return stack[top];
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

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
        }

        while (top > -1) {
            System.out.println(stack[top--]);
        }

    }

    //判断优先级
    public int priority(int opera) {
        return switch (opera) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    //判断是不是一个运算符

    public boolean isOpera(char val) {
        return val == '+' || val == '-' || val == '/' || val == '*';
    }

    //计算
    public int  cal(int num1,int num2,int opera){
        int res = 0;

        switch (opera){
            case '+' -> res = num1 +num2;
            case  '-' -> res = num1- num2;
            case '*' -> res = num1 * num2;
            case  '/' -> res = num1 / num2;
        }



        return res;
    }


}