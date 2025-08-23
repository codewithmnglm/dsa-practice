package com.practice.dsa;


import java.text.CollationElementIterator;
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



    static boolean check(int i, int n) {

        int pow = (int) Math.pow(2, i);
        if (pow == n) return true;
        else if (pow > n || n % 2 != 0) return false;
        return check(i + 1, n);

    }


    public static void main(String[] args) {


        int[] ar = {12, 1, 4, 9, 11};

        // System.out.println(subsets(ar));
        // ArrayList<Integer> al = new ArrayList<>();
        //System.out.println(printSubsequences(0,al,ar,3));
        // printSubsequences(0,al,ar,3);
        //System.out.println(subsetsSum(ar));

        // System.out.println(frogJumpKStepsTabulation(ar, 4));
        System.out.println(nonAdjacentTabulation(ar));


    }
}
