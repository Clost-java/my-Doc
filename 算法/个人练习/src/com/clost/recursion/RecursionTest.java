package com.clost.recursion;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author clost
 * @date 2022/9/14 9:25
 */
public class RecursionTest {

    @Test
    public void test() {

        test2(10);
//        System.out.println(factorial(3));

    }


    public static void test2(int n) {
        if (n > 2) {
            test2(n - 1);
        } else {
            System.out.println("n = " + n);
        }


    }

    public static int factorial(int n) {



        if (n == 1) {
            return 1;
        } else {
            System.out.println(n);
            return factorial(n - 1) * n;
        }
    }
}
