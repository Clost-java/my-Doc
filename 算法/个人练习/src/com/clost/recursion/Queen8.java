package com.clost.recursion;

/**
 * @author clost
 * @date 2022/9/15 9:23
 */
public class Queen8 {


    //皇后的数量
    public static int maxQueen = 8;
    //用来存放游戏的结果,数组的下标代表第n+1行
    public static int[] resArr = new int[maxQueen];

    public static void main(String[] args) {


        setQueen(0);
    }


    //判断第n个皇后是否与之前摆放的皇后冲突
    //判断是否在同列或统一对角线上
    public static boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            if (resArr[i] == resArr[n] || (n - i) == Math.abs(resArr[n] - resArr[i])) {
                return false;
            }
        }

        return true;
    }

    //打印一种解法
    public static void printRes() {
        for (int i = 0; i < resArr.length; i++) {
            System.out.print(resArr[i] + " ");
        }
        System.out.println();
    }


    public static void setQueen(int n) {
        if (n == maxQueen) {
            printRes();
            return;
        }
        for (int i = 0; i < maxQueen; i++) {
            resArr[n] = i;
            if (judge(n)) {
                setQueen(n + 1);
            }
        }

    }


}
