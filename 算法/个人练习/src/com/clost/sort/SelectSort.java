package com.clost.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author clost
 * @date 2022/11/15 14:40
 */

@SuppressWarnings({"all"})
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("排序前时间是:" + simpleDateFormat.format(new Date()));


        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        System.out.println("排序前时间是:" + simpleDateFormat.format(new Date()));
//        System.out.println("排列后的数组为：");
//        for (int item : arr) {
//            System.out.print(item + "\t");
//        }

    }
}
