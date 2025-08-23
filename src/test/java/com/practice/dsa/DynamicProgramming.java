package com.practice.dsa;

import java.util.*;

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

    public static String frequencySort(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) hm.put(c, hm.get(c) + 1);
            else hm.put(c, 1);
        }
        ArrayList<Character> list = new ArrayList<>(hm.keySet());
        list.sort((a, b) -> hm.get(b) - hm.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int freq = hm.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static int climbStairs(int n) {


        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs2(n, dp);


    }

    public static int climbStairs2(int n, int[] dp) {

        if (n <= 3) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairs2(n - 2, dp) + climbStairs2(n - 1, dp);
        return dp[n];

    }

    public static List<List<Integer>> generate(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] lst = new Integer[i + 1];
            Arrays.fill(lst, 1);
            ans.add(Arrays.asList(lst));
        }

        for (int i = 2; i < n; i++) {

            for (int j = 1; j < ans.get(i).size() - 1; j++) {

                List<Integer> subList = ans.get(i - 1);
                ans.get(i).set(j, subList.get(j - 1) + subList.get(j));
            }
        }
        return ans;
    }

    public static List<List<Integer>> generate2(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] lst = new Integer[i + 1];
            Arrays.fill(lst, 1);
            ans.add(Arrays.asList(lst));
        }

        for (int i = 2; i < n; i++) {

            for (int j = 1; j < ans.get(i).size() - 1; j++) {

                List<Integer> subList = ans.get(i - 1);
                ans.get(i).set(j, subList.get(j - 1) + subList.get(j));
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);

        }

        return max;
    }

    public static int frogJump(int i, int[] arr, int cost) {

        if (i == arr.length - 1) {
            return cost;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;


        if (i + 1 < arr.length) {
            left = frogJump(i + 1, arr, cost + Math.abs(arr[i + 1] - arr[i]));
        }


        if (i + 2 < arr.length) {
            right = frogJump(i + 2, arr, cost + Math.abs(arr[i + 2] - arr[i]));
        }

        return Math.min(left, right);

    }

    public static int frogJumpDPMemoization(int i, int[] arr, int[] dp) {

        if (i == arr.length - 1) {
            return 0;
        }
        if (dp[i] != -1) return dp[i];

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;


        if (i + 1 < arr.length) {

            left = frogJumpDPMemoization(i + 1, arr, dp) + Math.abs(arr[i + 1] - arr[i]);
        }

        if (i + 2 < arr.length) {

            right = frogJumpDPMemoization(i + 2, arr, dp) + Math.abs(arr[i + 2] - arr[i]);
        }

        return dp[i] = Math.min(left, right);

    }

    public static int frogJumpDPTabulation(int[] arr){

        int len= arr.length;
        int [] dp=new int[len];
        dp[0]=0;
        dp[1]=20;

        for(int i=2;i<len;i++){

            dp[i]= Math.min(dp[i-1]+Math.abs(arr[i] - arr[i - 1]),dp[i-2]+Math.abs(arr[i] - arr[i - 2]));

        }

        return dp[len-1];
    }


    public static int frogJumpKStepsTabulation(int[] arr, int k) {

        int len = arr.length;
        int[] dp = new int[len];

        dp[0] = 0;

        for (int i = 1; i < len; i++) {

            int a1 = 0, a2 = 0;

            a1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            if (i - k < 0) {
                a2 = dp[0] + Math.abs(arr[i] - arr[0]);
            } else {
                a2 = dp[i - k] + Math.abs(arr[i] - arr[i - k]);
            }

            dp[i] = Math.min(a2, a1);

        }
        return dp[len - 1];

    }

    public static int nonAdjacent(int[] nums) {
        int max = Integer.MIN_VALUE;

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = (i == 0) ? 2 : 0; j < len; j++) {

                if (i == len - 1) {
                    len = len - 1;
                    max = Math.max(max, nums[i] * nums[j]);
                } else if (j == i - 1 || j == i + 1 || j == i) continue;
                else {
                    max = Math.max(max, nums[i] * nums[j]);
                }

            }


        }


        return max;
    }

    public static int nonAdjacentTabulation(int[] nums) {
        int max = Integer.MIN_VALUE;

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {

            if (i - 2 > 0) max = Math.max(dp[i - 2] + nums[i], nums[i]);

            else max = Math.max(dp[i - 1], nums[i]);

            dp[i] = Math.max(dp[i - 1], nums[i]);

        }


        return max;
    }

    public int buyStocks1(int[] prices) {

        int len= prices.length;
        int [] dp= new int[len];
        dp[0]=prices[0];
        int minPrice=prices[0];
        int profit=0;

        for(int i=1;i<len;i++){
            minPrice=Math.min(minPrice,dp[i-1]);
            profit= Math.max(profit,prices[i]-minPrice);
            dp[i]=Math.min(prices[i],dp[i-1]);

        }

        return Math.max(profit, 0);

    }

    public static void main(String[] args) {


        int nums[] = {30, 10, 60, 10, 60, 50};

        // System.out.println(minCostClimbingStairs(nums));


        // System.out.println(frogJump(0,nums,0));
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
       // System.out.println(frogJumpDPMemoization(0, nums, dp));
        // for(int i:dp) System.out.println(i);
        System.out.println(frogJumpDPTabulation(nums));

    }
}
