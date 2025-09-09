package com.practice.dsa;


import java.util.*;

public class Recursion {

    static int count = 0;

    static int maxLen = 0;

    static boolean check(int i, int n) {

        int pow = (int) Math.pow(2, i);
        if (pow == n) return true;
        else if (pow > n || n % 2 != 0) return false;
        return check(i + 1, n);

    }

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

    public static int[] reverseArray(int i, int j, int[] arr) {

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
        System.out.println("Index ------" + (i + 1));
        System.out.println("DS --" + al);
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

    public static char kthCharacter(int k, List<Character> al) {

        if (al.size() >= k) {
            return al.get(k - 1);
        }

        StringBuilder s = new StringBuilder();
        for (char p : al) {
            s.append((char) (p + 1));
        }
        for (int i = 0; i < s.length(); i++) {
            al.add(s.charAt(i));
        }
        return kthCharacter(k, al);

    }

    public static boolean isPowerOfTwo(int n) {

        int i = 0;
        return Recursion.check(0, n);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<Integer>());
        return ans;


    }

    private static void findCombination(int i, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (i == arr.length) return;

        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombination(i, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombination(i + 1, arr, target, ans, ds);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        findCombination2(0, candidates, 8, ans, new ArrayList<Integer>());
        return ans;

    }

    private static void findCombination2(int i, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (i == arr.length) return;

        if (arr[i] <= target) {
            ds.add(arr[i]);
            findCombination2(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombination2(i + 1, arr, target, ans, ds);

    }

    public static List<Integer> subsetsSum(int[] nums) {
        List<Integer> subSet = new ArrayList<>();

        findSubsets(0, 0, nums, subSet);
        Collections.sort(subSet);
        return subSet;

    }

    public static void findSubsets(int i, int sum, int[] arr, List<Integer> subSets) {

        if (i == arr.length) {
            subSets.add(sum);
            return;

        }

        findSubsets(i + 1, sum + arr[i], arr, subSets);


        findSubsets(i + 1, sum, arr, subSets);


    }

    public static int isSubsetSum(int[] arr, int target) {
        return subSetK(0, arr, target);
    }

    public static int subSetK(int i, int[] arr, int target) {

        if (target == 0) return 1;
        if (i == arr.length) return 0;
        int left = subSetK(i + 1, arr, target - arr[i]);
        int right = subSetK(i + 1, arr, target);
        return left + right;


    }

    public static int ninjaTraining(int n, int points[][]) {

        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        // start at day 0 with last = 3 (no previous)
        return solve(0, 3, points, dp);
    }

    private static int solve(int day, int last, int[][] points, int[][] dp) {
        if (day == points.length) return 0;           // Base case

        if (dp[day][last] != -1) return dp[day][last]; // Memo hit

        int best = 0;
        for (int act = 0; act < 3; act++) {
            if (act != last) { // can't repeat yesterday's activity
                int take = points[day][act] + solve(day + 1, act, points, dp);
                if (take > best) best = take;
            }
        }
        return dp[day][last] = best; // store and return
    }

    public static int minFallingPathSum(int[][] matrix) {

        int minPath = Integer.MAX_VALUE;

        for (int j = 0; j < matrix.length; j++) {

            minPath = Math.min(calculateMinFallingPathSum(0, j, matrix), minPath);
        }

        return minPath;

    }

    static int calculateMinFallingPathSum(int i, int j, int[][] matrix) {

        int n = matrix.length;

        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        if (i == n - 1) return matrix[i][j];

        int right = calculateMinFallingPathSum(i + 1, j + 1, matrix);
        int left = calculateMinFallingPathSum(i + 1, j - 1, matrix);
        int down = calculateMinFallingPathSum(i + 1, j, matrix);


        return matrix[i][j] + Math.min(down, Math.min(left, right));
    }

    public static int subSetK2(int i, int[] arr, int target) {
        if (target == 0) return 1;
        if (i >= arr.length) return 0;
        int left = subSetK2(i + 1, arr, target);
        int right = 0;
        if (arr[i] <= target) {
            right = subSetK2(i + 1, arr, target - arr[i]);
        }

        return left + right;


    }

    public static int MinimumCoins(int[] coins, int amount) {

        int ans = calculateCoins(coins.length - 1, coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int calculateCoins(int i, int[] coins, int amount) {

        if (i == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return Integer.MAX_VALUE;
        }

        int no = calculateCoins(i - 1, coins, amount);
        int yes = Integer.MAX_VALUE;
        if (amount >= coins[i]) {
            int sub = calculateCoins(i, coins, amount - coins[i]);
            if (sub != Integer.MAX_VALUE) {
                yes = 1 + sub;
            }
        }
        return Math.min(yes, no);

    }

    public static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return calculateMax(n - 1, wt, val, W);

    }

    public static int calculateMax(int i, int[] wt, int[] val, int W) {
        // Base case: only item 0 available
        if (i == 0) {
            if (wt[0] <= W) {
                return (W / wt[0]) * val[0];  // take as many as possible
            }
            return 0;
        }

        // Option 1: don't take item i
        int no = calculateMax(i - 1, wt, val, W);

        // Option 2: take item i (stay at same i since it's unbounded)
        int yes = Integer.MIN_VALUE;
        if (wt[i] <= W) {
            yes = val[i] + calculateMax(i, wt, val, W - wt[i]);
        }

        return Math.max(no, yes);
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        return f(len1 - 1, len2 - 1, text1, text2);


    }

    public static int f(int i, int j, String text1, String text2) {

        if (i < 0 || j < 0) return 0;

        char a = text1.charAt(i);
        char b = text2.charAt(j);

        if (a == b) return 1 + f(i - 1, j - 1, text1, text2);

        else return Math.max(f(i - 1, j, text1, text2), f(i, j - 1, text1, text2));


    }

    public static String printLCS(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        String res = lcs(len1 - 1, len2 - 1, text1, text2);

        return !res.isEmpty() ? res : "No Valid String Found";


    }

    public static String lcs(int i, int j, String text1, String text2) {

        if (i < 0 || j < 0) return "";

        char a = text1.charAt(i);
        char b = text2.charAt(j);

        if (a == b) return lcs(i - 1, j - 1, text1, text2) + a;

        else {
            String s1 = lcs(i - 1, j, text1, text2);
            String s2 = lcs(i, j - 1, text1, text2);

            return s1.length() > s2.length() ? s1 : s2;
        }


    }

    public static String printLCSubString(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        String max = "";
        String cur = "";

        String res = f1(len1 - 1, len2 - 1, text1, text2, max, cur);

        return !res.isEmpty() ? res : "No Valid String Found";


    }

    public static String f1(int i, int j, String text1, String text2, String max, String cur) {

        if (i < 0 || j < 0) return "";

        char a = text1.charAt(i);
        char b = text2.charAt(j);

        if (a == b) return f1(i - 1, j - 1, text1, text2, max, cur) + a;

        else {
            if (cur.length() > max.length()) {
                max = cur;
            }
            cur = "";
            String s1 = f1(i - 1, j, text1, text2, max, cur);
            String s2 = f1(i, j - 1, text1, text2, max, cur);
            return s1.length() > s2.length() ? s1 : s2;
        }


    }


    public static int longestPalindromeSubsequence(String s) {


        return f2(s, 0, s.length() - 1);
    }


    public static int f2(String s, int i, int j) {

        if (i > j) return 0;

        if(i==j) return 1;

        char a = s.charAt(i);
        char b = s.charAt(j);

        if (a == b) return 2 + f2(s, i + 1, j - 1);
        else {

            return Math.max(f2(s, i, j - 1), f2(s, i + 1, j));

        }

    }


    public static int longestPalindromeSubString(String s) {
        maxLen = 0;
        f3(s, 0, s.length() - 1);
        return maxLen;
    }


    private static void f3(String s, int i, int j) {
        if (i > j) return;


        if (isPalindrome(s, i, j)) {
            maxLen = Math.max(maxLen, j - i + 1);
        }


        f3(s, i + 1, j);
        f3(s, i, j - 1);
    }
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }



    public static void main(String[] args) {


        int[] ar = new int[]{9, 6, 5, 1};


        // System.out.println(MinimumCoins(ar, 11));

        int[] val = {5, 11, 13};
        int[] wt = {2, 4, 6};
        int W = 10;


        // System.out.println(unboundedKnapsack(wt, val, wt.length, W));


       // System.out.println(printLCSubString("xyzabcmn", "pqabcmr"));


      //  System.out.println(longestPalindromeSubsequence("cbbd"));

        System.out.println(longestPalindromeSubString("cbbd"));


    }
}
