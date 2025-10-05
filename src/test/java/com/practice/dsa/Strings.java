package com.practice.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Strings {

    public static int longestPalindromeUsingHashMap(String s) {

        HashMap<Character, Integer> hm = new HashMap();

        for (int i = 0; i < s.length(); i++) {

            char p = s.charAt(i);
            if (hm.containsKey(p)) hm.put(p, hm.get(p) + 1);
            else hm.put(p, 1);

        }
        int count = 0;
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {

            if (entry.getValue() % 2 == 0) count = count + entry.getValue();

            else if (entry.getValue() == 1 && flag) {
                count = count + 1;
                flag = false;
            } else if (entry.getValue() % 2 != 0) {

                count = count + entry.getValue() - 1;
                if (flag) {
                    count = count + 1;
                    flag = false;
                }
            }


        }
        return count;

    }

    public static int longestPalindromeUsingFreqCount(String s) {

        int count = 0;
        int[] freq = new int[128];
        for (char c : s.toCharArray()) freq[c]++;
        boolean oddFound = false;

        for (int f : freq) {

            if (f % 2 == 0) count = count + f;
            else {
                count += f - 1;
                oddFound = true;
            }

            if (oddFound) count++;
            return count;
        }

        return count;

    }

    public static int minInsertions(String s) {

        int count = 0;
        int oneCount = 0;
        int oddCount = 0;
        int[] freq = new int[128];
        for (char c : s.toCharArray()) freq[c]++;

        for (int f : freq) {

            if (f == 1) {
                oneCount++;
            } else if (f % 2 != 0 && f / 2 != 0) {
                oddCount++;
            }
        }

        System.out.println(oneCount);
        System.out.println(oddCount);
        if (oddCount > 0) count = oddCount + oneCount;
        else count = oneCount;

        return count - 1;

    }

    public static int findMinimumOperations(String s1, String s2, String s3) {

        if (s1.charAt(0) != s2.charAt(0) || s2.charAt(0) != s3.charAt(0)) return -1;

        if (s1.equalsIgnoreCase(s2) && s2.equalsIgnoreCase(s3)) return 0;

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        int i = 0, j = 0, k = 0, count = 0;

        while (i < l1 && j < l2 && k < l3) {

            char a = s1.charAt(i);
            char b = s2.charAt(j);
            char c = s3.charAt(k);

            if (a == b && b == c) {
                count++;
                i++;
                j++;
                k++;
            } else break;


        }
        count = l1 - count + l2 - count + l3 - count;
        System.out.println(count);
        return count > 0 ? count : -1;

    }

    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> st = new Stack();

        for (int i = 0; i < s.length(); i++) {

            char p = s.charAt(i);

            if (p == '#') {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p);
            }

        }

        StringBuilder sb = new StringBuilder();

        if (!st.isEmpty()) for (char p : st) sb.append(p);

        Stack<Character> st2 = new Stack();

        for (int i = 0; i < t.length(); i++) {

            char p = t.charAt(i);

            if (p == '#') {
                if (!st2.isEmpty()) st2.pop();
            } else {
                st2.push(p);
            }

        }

        StringBuilder sb1 = new StringBuilder();

        if (!st2.isEmpty()) for (char p : st2) sb1.append(p);


        return sb.toString().contentEquals(sb1);

    }

    public static String removeStars(String s) {

        Stack<Character> st = new Stack();

        for(int i=0;i<s.length();i++){

            char p = s.charAt(i);

            if (p == '*') {
                if (!st.isEmpty()) st.pop();
            } else {
                st.push(p);
            }


        }

        StringBuilder sb = new StringBuilder();

        for(char p:st) sb.append(p);

        return sb.toString();

    }




    public static void main(String[] args) {


        // System.out.println(minInsertions("zjveiiwvc")); //z j e w c - ii vv--

        // System.out.println(findMinimumOperations("a","aabc","a"));

       // System.out.println(backspaceCompare("a##c", "#a#c"));

        System.out.println(removeStars("leet**cod*e"));

    }


}
