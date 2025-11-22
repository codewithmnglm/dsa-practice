package com.practice.dsa;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

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

    public static int longestSubarrayWithSumK(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum == k) maxLen = Math.max(maxLen, i + 1);

            else if (hm.containsKey(sum - k)) maxLen = Math.max(maxLen, i - hm.get(sum - k));

            else hm.put(sum, i);
        }
        return maxLen;
    }

    public static void printSubArrays(int[] nums, int p) {

        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                int sum = 0, count = 0;
                for (int k = i; k <= j; k++) {

                    System.out.print(nums[k] + ",");
                    count++;
                    sum = sum + nums[k];
                    if (sum == p) maxLen = Math.max(maxLen, count);

                }
                System.out.println();


            }
        }
        System.out.println(maxLen);

    }

    public int pivotIndexLC724(int[] nums) {

        int totalSum = 0;

        for (int p : nums) totalSum = totalSum + p;

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (leftSum == totalSum - nums[i] - leftSum) return i;

            leftSum = leftSum + nums[i];

        }


        return -1;

    }

    public int findMiddleIndexLC1991(int[] nums) {

        int totalSum = 0;

        for (int p : nums) totalSum = totalSum + p;

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (leftSum == totalSum - nums[i] - leftSum) return i;

            leftSum = leftSum + nums[i];

        }


        return -1;

    }

    public static int[] productExceptSelfLC238(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];


        left[0] = 1;
        for (int i = 1; i < left.length; i++) left[i] = left[i - 1] * nums[i - 1];

        right[nums.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i + 1];

        for (int i = 0; i < nums.length; i++) nums[i] = left[i] * right[i];

        return nums;


    }

    public static boolean checkSubarraySumLC523(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            int rem = sum % k;
            if (map.containsKey(rem)) {
                int prevIndex = map.get(rem);

                // Subarray size must be at least 2
                if (i - prevIndex >= 2) {
                    return true;
                }

            } else {
                // Only store the FIRST occurrence of this remainder
                map.put(rem, i);
            }


        }
        return false;
    }

    public int[] leftRightDifferenceLC2574(int[] nums) {

        int totalSum = 0;

        for (int p : nums) totalSum = totalSum + p;

        int leftSum = 0;

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - nums[i] - leftSum;

            res[i] = Math.abs(rightSum - leftSum);

            leftSum = leftSum + nums[i];

        }
        return res;

    }

    public static long maximumSubarraySum(int[] nums, int k) {

        int maxSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();


        int[] prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {

            prefixSum[i + 1] = prefixSum[i] + nums[i];
            map.put(i + 1, prefixSum[i + 1]);
            if (map.containsKey(i - k)) {
                maxSum = Math.max(maxSum, map.get(i + 1) - map.get(i - k));
            }

        }


        return maxSum;
    }

    public static int findMaxLengthLC525(int[] nums) {
        int max = 0;
        int sum = 0;


        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) sum = sum - 1;
            else sum = sum + 1;

            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                max = Math.max(max, i - prevIndex);

            } else map.put(sum, i);

        }


        return max;
    }

    public static int longestSubArrayWithSumK(int[] arr, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int prefSum = 0;

        for (int i = 0; i < arr.length; ++i) {
            prefSum += arr[i];


            if (prefSum == k)
                res = i + 1;


            else if (mp.containsKey(prefSum - k))
                res = Math.max(res, i - mp.get(prefSum - k));


            if (!mp.containsKey(prefSum))
                mp.put(prefSum, i);
        }

        return res;
    }

    public static int numSubarraysWithSumLC930(int[] nums, int k) {


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

        int[] ar = {0, 1};

        // System.out.println(longestSubarrayWithSumK(ar, 5));

        //  System.out.println(maximumSubarraySum(ar,1));

        // System.out.println(checkSubarraySumLC523(ar,3));

        System.out.println(findMaxLengthLC525(ar));


    }
}
