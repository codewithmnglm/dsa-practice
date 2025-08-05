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

        HashMap<Character,Integer> hm= new HashMap<>();

        for(char c:s.toCharArray()){
            if(hm.containsKey(c)) hm.put(c,hm.get(c)+1);
            else hm.put(c,1);
        }
        ArrayList<Character> list = new ArrayList<>(hm.keySet());
        list.sort((a,b) -> hm.get(b) -hm.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c:list){
            int freq = hm.get(c);
            for(int i=0;i<freq;i++){
                sb.append(c);
            }
        }
        return sb.toString();

    }






    public static void main(String[] args) {


         Integer nums[] = {1,100,1,1,1,100,1,1,100,1};

        // System.out.println(minCostClimbingStairs(nums));




        System.out.println(frequencySort("tree"));





    }
}
