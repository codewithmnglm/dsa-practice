package com.practice.dsa;

import java.util.*;

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

    public static int lengthOfLongestSubstrings(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int left = 0;
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            while (charSet.contains(currentChar)) {
                char charLeft = s.charAt(left);
                charSet.remove(charLeft);
                left = left + 1;
            }

            charSet.add(currentChar);

            int currentLength = right - left + 1;
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;

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

    public static String longestPalindrome5(String s) {
        int n = s.length();
        if (n == 0) return "";

        String result = s.substring(0, 1); // Start with 1st char as the longest

        for (int center = 0; center < n; center++) {
            // Check for odd-length palindromes (single center)
            result = expandAndUpdate(s, center, center, result);
            // Check for even-length palindromes (two centers)
            result = expandAndUpdate(s, center, center + 1, result);
        }

        return result;
    }

    // Helper function to expand around center and update result
    private static String expandAndUpdate(String s, int left, int right, String currentBest) {
        int n = s.length();

        // Expand as long as characters match and within bounds
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Substring from left+1 to right-1 is the palindrome
        String newPalindrome = s.substring(left + 1, right);

        // Update if new one is longer
        if (newPalindrome.length() > currentBest.length()) {
            return newPalindrome;
        } else {
            return currentBest;
        }
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s1.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {

            if (hm.containsKey(s2.charAt(i))) {
                boolean flag = checkAnagram(s1, s2.substring(i, i + s1.length()));
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkAnagram(String a, String b) {

        int[] alpha = new int[26];
        for (char c : b.toCharArray()) {
            alpha[c - 'a']++;
        }

        for (char c : a.toCharArray()) {
            alpha[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) return false;
        }
        return true;


    }

    public static int subarraySum(int[] nums, int k) {

        int l = 0, r = 0, sum = 0, maxSum = 0;

        while (r < nums.length) {
            sum = sum + nums[r];
            while (sum > k) {
                sum = sum - nums[l];
                l++;
            }
            maxSum = Math.max(maxSum, r - l + 1);
            r++;


        }


        return maxSum;
    }

    public static int maxScoreLC1423(int[] cardPoints, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++) sum = sum + cardPoints[i];
        int maxSum = sum;

        int j = cardPoints.length - 1;
        int i = k - 1;

        while (i >= 0) {

            sum = sum - cardPoints[i] + cardPoints[j];
            maxSum = Math.max(sum, maxSum);
            i--;
            j--;
        }


        return maxSum;
    }

    public static int longestOnesLC1004(int[] nums, int k) {
        int l = 0, r = 0, maxLen = 0;
        int zeroCount = 0;

        while (r < nums.length) {

            if (nums[r] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[l] == 0) zeroCount--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;


        }

        return maxLen;

    }

    public static int LC209(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;

        while (r < nums.length) {

            sum = sum + nums[r];

            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum = sum - nums[l++];
            }
            r++;


        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

    public static int LC3364(List<Integer> nums, int l, int r) {


        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); ++i) {
            int curr = 0;
            for (int j = i; j < nums.size(); ++j) {
                curr += nums.get(j);
                int len = j - i + 1;
                if (len >= l && len <= r && curr > 0) minSum = Math.min(minSum, curr);
                if (len > r) break;
            }
        }


        return minSum != Integer.MAX_VALUE ? minSum : -1;


    }

    public static void LC904(int[] fruits) {

        int l=0,r=0,maxLen=0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        while(r<fruits.length){

            hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1);

           while(hm.size()>2){

               hm.put(fruits[l], hm.get(fruits[l]) - 1);

               if (hm.get(fruits[l]) == 0) {
                   hm.remove(fruits[l]);
               }
               l++;


           }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;



        }
        System.out.println(maxLen);

    }


    public static void main(String[] args) {


        int[] ar = new int[]{1,2,3,2,2};
        int k = 3;

        // System.out.println(LC3364(ar, 2, 3));

        LC904(ar);

    }
}
