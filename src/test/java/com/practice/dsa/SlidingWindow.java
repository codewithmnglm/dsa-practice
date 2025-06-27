package com.practice.dsa;

public class SlidingWindow {

    public static void maxSumSubarraySize(int[] arr, int k) {

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) sum = sum + arr[i];


        for (int i = k; i < arr.length; i++) {

            sum = sum + arr[i] - arr[i - k];
            maxSum = Integer.max(sum, maxSum);
        }
        System.out.println(maxSum);

    }




    public static void main(String[] args) {


        int[] arr = {2, 2, 1, 5, 3, 0};
        maxSumSubarraySize(arr, 2);

    }
}
