package com.practice.dsa;

import java.util.HashMap;

public class PrefixSum {


    public static int subarraySumLC560(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        hm.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];


            if (hm.containsKey(sum - k)) {

                count = count + hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }


        return count;
    }

    public int numberOfSubarraysLC1248(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0) nums[i] = 0;
            else nums[i] = 1;

        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        hm.put(0, 1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            if (hm.containsKey(sum - k)) {

                count = count + hm.get(sum - k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] ar = {10, 2, -2, -20, 10};
        System.out.println(subarraySumLC560(ar, -10));

    }
}
