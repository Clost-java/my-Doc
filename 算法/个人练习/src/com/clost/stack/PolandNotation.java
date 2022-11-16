package com.clost.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author clost
 * @date 2022/9/11 10:37
 */
public class PolandNotation {

    public static void main(String[] args) {
        //定义逆波兰表达式
        //(3+4)x5-6 ==>  3 4 + 5 x 6 -

        String suffixExpression = "30 4 + 5 * 6 -";
        List<String> newExpression = getListString(suffixExpression);
        System.out.println(newExpression);
//        System.out.println("计算结果为: "+calculate(newExpression));
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> pa = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List");
        System.out.println(pa);

    }


    public static List<String> parseSuffixExpressionList(List<String> list) {

        Stack<String> stack1 = new Stack<>();

        ArrayList<String> stack2 = new ArrayList<>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                stack2.add(item);
            } else if (item.equals("(")) {
                stack1.push(item);
            } else if (item.equals(")")) {
                while (!stack1.peek().equals("(")) {
                    stack2.add(stack1.pop());
                }
                stack1.pop();
            } else {

                while (stack1.size() != 0 && Operation.getValue(stack1.peek()) >= Operation.getValue(item)) {
                    stack2.add(stack1.pop());
                }
                stack1.push(item);

            }
        }

        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }


        return stack2;
    }

    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<String>();
        String str;
        int i = 0;

        do {
            char c = s.charAt(i);
            if (c < 48 || c > 57) {
                list.add(c + "");
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }

                list.add(str);

            }
        } while (i < s.length());


        return list;


    }

    public static List<String> getListString(String suffixExpression) {
        String[] newExpression = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String item : newExpression) {
            list.add(item);
        }
        return list;
    }

    public static int calculate(List<String> list) {

        //创建一个栈
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                //取出两个数，运算后再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (item) {
                    case "+" -> result = num2 + num1;
                    case "-" -> result = num2 - num1;
                    case "*" -> result = num2 * num1;
                    case "/" -> result = num2 / num1;
                    default -> throw new RuntimeException("输出的表达式有误!");
                }

                stack.push(result + "");

            }
        }

        //最后留在栈中的数据即是计算结果
        return Integer.parseInt(stack.pop());
    }

}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;


    public static int getValue(String operation) {
        int result = 0;

        switch (operation) {
            case "+" -> result = ADD;
            case "-" -> result = SUB;
            case "*" -> result = MUL;
            case "/" -> result = DIV;
            default -> System.out.println("error");
        }


        return result;
    }
}
