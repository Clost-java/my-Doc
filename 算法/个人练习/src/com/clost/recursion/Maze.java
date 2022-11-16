package com.clost.recursion;

import com.sun.source.tree.IfTree;

/**
 * @author clost
 * @date 2022/9/14 21:44
 */
public class Maze {

    public static void main(String[] args) {

        //创建一个二维数组，模拟迷宫
        //地图

        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        getWay(map,1,1);

        for (int[] row : map) {
            for (int item : row) {
                System.out.print(item + "\t");
            }

            System.out.println();

        }


    }

    /**
     *
     * @return
     */

    public static boolean getWay(int[][] map, int i, int j){

        if (map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(getWay(map,i + 1,j)){
                    return true;
                }else if(getWay(map,i,j + 1)){
                    return true;
                }else if(getWay(map,i - 1,j)){
                    return false;
                }else if(getWay(map,i,j - 1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
