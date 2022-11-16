package com.clost.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author clost
 * @date 2022/11/15 15:13
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("排序前时间是:" + simpleDateFormat.format(new Date()));


        for (int i = 1; i < arr.length; i++) {

            int insertVal = arr[i];
            int insertIndex = i -1 ;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){

                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;

        }


        for (int i = 1; i < arr.length; i++) {

            int insertVal = arr[i];
            int insertIndex = i -1;
            for(int j = i - 1; j >= 0; j--){

                if(insertVal < arr[j]){
                    insertIndex--;
                    arr[j+1] = arr[j];
                }
            }
            arr[insertIndex + 1] = insertVal;
        }

        System.out.println("排序前时间是:" + simpleDateFormat.format(new Date()));

//        for (int item :arr) {
//            System.out.print(item + "\t");
//        }


    }
}
