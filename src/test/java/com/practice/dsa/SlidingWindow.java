package com.practice.dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void smallestSubarrayWithSumGreaterThanS(int[] arr, int s) {

        int len = arr.length;
        int sum = 0;
        int left = 0;
        int maxLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {

            sum = sum + arr[i];
            while (sum > s && left <= i) {

                maxLen = Math.min(maxLen, i - left + 1);
                sum = sum - arr[left];
                left++;
            }


        }
        System.out.println(maxLen);

    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int sumLen = 0;
        for (int i = 0; i < nums.size(); i++) {

            sum = sum + nums.get(i);
            sumLen = i - left + 1;
            while (sum > 0 && sumLen >= l && sumLen <= r) {

                minLen = Integer.min(sum, minLen);
                sum = sum - nums.get(left);
                left++;


            }


        }


        return -1;
    }

    public static int maximumSubarraySum(int[] nums) {


        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;

    }

    public static int lengthOfLongestSubstring(String s) {

        int maxLen = Integer.MIN_VALUE, len = 0, left = 0;
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {

            while (set.contains(c[i])) {
                set.remove(c[left]);
                left++;
            }
            set.add(c[i]);
            maxLen = Math.max(maxLen, set.size());

        }
        return maxLen > s.length() ? maxLen : 0;
    }

    public static int lenMaxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        int left = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > max) {
                max = sum;
                maxLen = Math.max(maxLen, i - left + 1);
            } else if (sum < 0) {
                sum = 0;
                left = i + 1;
                maxLen = 0;
            }
        }

        return maxLen;
    }

    public static int getMaxLen(int[] nums) {

        int left = 0, maxlen = 0;
        int maxProd = 1, prod = 1;
        for (int i = 0; i < nums.length; i++) {

            prod = prod * nums[i];
            if (prod == 0) {
                left = i + 1;
                prod = 1;

            } else if (prod < 0 && i < nums.length - 1) {

                if (nums[i + 1] > 0) {
                    left = i + 1;
                    prod = 1;
                }

            } else if (prod > maxProd) {
                maxProd = prod;
                maxlen = Math.max(i - left + 1, maxlen);
            }


        }
        return maxlen;


    }

    public static int maxProduct(int[] nums) {
        int negProd = 1;
        int maxNegProd = 1;
        int posProd = 1;
        int maxPosProd = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                maxNegProd = 0;
                negProd = 1;
                posProd = 1;
            } else if (nums[i] < 0) {
                negProd = negProd * nums[i];
                maxPosProd = posProd;
                posProd = 1;

            } else {
                posProd = posProd * nums[i];
                maxPosProd = Math.max(maxPosProd, posProd);
                negProd = negProd * nums[i];
            }


        }

        if (negProd == 1 && posProd == 1) return 0;

        if (negProd < 0 && posProd == 1) return negProd;

        return Math.max(maxNegProd, maxPosProd);
    }

    public static String longestNiceSubstring2(String s) {

        int l = 0, r = 0, p = 0, q = 0;
        int maxLen = 1;
        String res = "";

        char[] c = s.toCharArray();

        if (s.length() == 2) {
            if (Math.abs(c[0] - c[1]) == 32) res = s;
            else res = "";
        } else {

            for (int i = 0; i < c.length - 1; i++) {

                if (c[i] - c[i + 1] == 0) {
                    r++;
                    p++;


                } else if (Math.abs(c[i] - c[i + 1]) == 32) {
                    r++;
                    q++;

                } else {
                    if (maxLen < (r - l + 1)) res = s.substring(l, r + 1);
                    l = i + 1;
                    r = i + 1;

                }

            }
            if (p == 0 && q == 0) res = "";

        }


        return res;

    }

    public static String longestNiceSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(Character.toUpperCase(s.charAt(i))) &&
                    charSet.contains(Character.toLowerCase(s.charAt(i)))) {
                continue;
            }
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i + 1));
            return s1.length() >= s2.length() ? s1 : s2;
        }
        return s;
    }


    public static String longestPalindrome(String s) {

        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {

            if (s.charAt(low) == s.charAt(high)) {
                String res = s.substring(low, high + 1);
                boolean flag = isPalindromic(res);
                if (flag) return res;
                else {
                    String s1 = s.substring(low, high);
                    String s2 = s.substring(low + 1, high + 1);
                    if (isPalindromic(s1) || isPalindromic(s2)) {
                        return isPalindromic(s1) ? s1 : s2;
                    } else {
                        low++;
                        high--;
                    }
                }

            } else {
                String s1 = s.substring(low, high);
                String s2 = s.substring(low + 1, high + 1);
                if (isPalindromic(s1) || isPalindromic(s2)) {

                    return isPalindromic(s1) ? s1 : s2;
                } else {
                    low++;
                    high--;
                }
            }


        }
        return "";
    }

    private static boolean isPalindromic(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (high >= low) {

            if (s.charAt(low) != s.charAt(high)) return false;
            else {
                low++;
                high--;
            }

        }
        return true;


    }


    public static void main(String[] args) {


        // int ar[] = {-2,-12,-1,-10};


        System.out.println(longestPalindrome("eabcb"));


    }
}
