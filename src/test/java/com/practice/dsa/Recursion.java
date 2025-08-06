package com.practice.dsa;


import java.util.*;

public class Recursion {

    static int count = 0;

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

    public static void printSubsequences(int i, List<Integer> al, int[] ar, int n) {

        if (i >= n) {
            if (al.isEmpty()) System.out.println("{}");
            al.forEach(System.out::print);
            System.out.println();
            return;
        }
        al.add(ar[i]);
        printSubsequences(i + 1, al, ar, n);
        al.remove(al.size() - 1);
        printSubsequences(i + 1, al, ar, n);


    }

    public static void printSubsequencesWithSumK(int i, List<Integer> al, int[] ar, int n, int k) {
        var sum = 0;
        if (i >= n) {
            for (int p : al) sum = sum + p;
            if (sum == k) {
                al.forEach(System.out::print);
                System.out.print(",");
            }
            return;
        }
        al.add(ar[i]);
        printSubsequencesWithSumK(i + 1, al, ar, n, k);
        al.remove(al.size() - 1);
        printSubsequencesWithSumK(i + 1, al, ar, n, k);


    }

    public static boolean printFirstSubsequencesWithSumK(int i, List<Integer> al, int[] ar, int n, int k) {
        if (i >= n) {
            int sum = 0;
            for (int p : al) sum += p;

            if (sum == k) {
                al.forEach(e -> System.out.print(e + " "));
                System.out.println();
                return true;
            }
            return false;
        }
        al.add(ar[i]);
        if (printFirstSubsequencesWithSumK(i + 1, al, ar, n, k)) return true;
        al.remove(al.size() - 1);
        return printFirstSubsequencesWithSumK(i + 1, al, ar, n, k);
    }

    public static int countSubsequencesWithSumK(int i, List<Integer> al, int[] ar, int n, int k) {
        if (i >= n) {
            int sum = 0;
            for (int p : al) sum += p;
            return (sum == k) ? 1 : 0;
        }
        al.add(ar[i]);
        int left = countSubsequencesWithSumK(i + 1, al, ar, n, k);

        al.remove(al.size() - 1);
        int right = countSubsequencesWithSumK(i + 1, al, ar, n, k);

        return left + right;
    }


    public static void main(String[] args) {


        int[] arr = {3, 2, 1};
        int k = 3;

        System.out.println(countSubsequencesWithSumK(0, new ArrayList<>(), arr, arr.length, k));
    }
}
