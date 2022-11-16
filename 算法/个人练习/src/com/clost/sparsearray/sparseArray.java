package com.clost.sparsearray;

/**
 * @author clost
 * @date 2022/8/31 9:51
 */
@SuppressWarnings({"all"})
public class sparseArray {

    public static void main(String[] args) {

        /**
         * 二维数组转稀疏数组，把二维数组中非零数据的位置记录到一个新的数组中
         * 1.稀疏数组第一行存放二维数组的行数、列数、非零值得个数
         * 其余的部分分别存储二维数组中非零数据的行、列、值
         */
        //创建二维数组11 * 11
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 1;

        //遍历初始数组
        System.out.println("初始二维数组是:");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();

        }

        //先遍历二维数组，得到非0数据的个数
        int sum = 0;

        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println("sum=" + sum);
        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];

                }
            }
        }
        System.out.println("二维数组转化后的稀疏数组");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();

        }

        /**
         * 读取稀疏数组，转化为二维数组
         * 1.先读取稀疏数组的第一行，获取二维数组的行数，列数，创建二维数组
         * 2.读取稀疏数组中非零数据的位置信息，赋给二维数组
         */

        //读取第一行数组
        int [][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //遍历稀疏数组，读取数据的行、列、值的信息
        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int val = sparseArray[i][2];
            chessArray2[row][col] = val;
        }
        System.out.println("还原后的二维组为:");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();

        }

    }
}
