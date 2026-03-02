package com.practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Stacks {


    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {


            if (c == '{' || c == '[' || c == '(') st.push(c);

            else if (st.isEmpty()) {
                if (c == '}' || c == ']' || c == ')') return false;
            } else if (c == '}' && st.peek() == '{') st.pop();

            else if (c == ']' && st.peek() == '[') st.pop();
            else if (c == ')' && st.peek() == '(') st.pop();

            else if (st.peek() == '{' && c == ']' || c == ')') return false;

            else if (st.peek() == '[' && c == ']' || c == '}') return false;

            else if (st.peek() == '(' && c == ']' || c == '}') return false;

        }
        return st.isEmpty();
    }


    public static int[] nextLargerElement(int[] arr) {

        Stack<Integer> st = new Stack<>();

        int[] res = new int[arr.length];
        Arrays.fill(res, -1);

        for (int i = arr.length - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();

            if(!st.isEmpty()) res[i]=st.peek();

            st.push(arr[i]);

            }



        return res;
    }


    public static void main(String[] args) {

        // System.out.println(isValid("([)]"));
        int[] ar = {6, 8, 0, 1, 3};
        int arr[] = nextLargerElement(ar);
        for (int i : arr) System.out.println(i);
    }
}
