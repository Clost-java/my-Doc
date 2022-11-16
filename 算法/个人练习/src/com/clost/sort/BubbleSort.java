package com.clost.sort;

/**
 * @author clost
 * @date 2022/11/15 8:53
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3, 9, -1, 10, -2};

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (flag) {
                break;
            }
        }


        for (int item : arr) {
            System.out.print(item + "\t");
        }

    }
}
