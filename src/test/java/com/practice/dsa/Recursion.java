package com.practice.dsa;


import java.util.*;

public class Recursion {

    public static void factorial(int n, int i) {

        if (n >= i) {

            factorial(n - 1, i);
            System.out.println(n);
        }


    }

    public static int paramFactorial(int i, int sum) {

        if (i < 1) {

            return sum;

        }

        return paramFactorial(i - 1, sum + i);


    }

    public static int[] reverseArray(int i, int j, int arr[]) {

        if (j < i) {
            return arr;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return reverseArray(i + 1, j - 1, arr);
    }

    public static boolean isPalindrome(int i, int j, String s) {

        char p = s.charAt(i);
        char q = s.charAt(j);

        if (j < i) {
            return true;
        }

        if (p != q) {
            return false;
        }

        return isPalindrome(i + 1, j - 1, s);
    }

    


    public static void main(String[] args) {


    }
}
