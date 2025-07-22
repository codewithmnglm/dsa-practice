package com.practice.dsa;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    public static int lengthOfLIS(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        int len = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                maxLen = maxLen + 1;
                max = nums[i];

            } else if (nums[i] > min) {


            } else {
                min = nums[i];

            }


        }

        return 1;
    }


    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }




    public static void main(String[] args) {


        // int nums[] = {1,100,1,1,1,100,1,1,100,1};

        // System.out.println(minCostClimbingStairs(nums));







    }
}
