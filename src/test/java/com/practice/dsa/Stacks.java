package com.practice.dsa;

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

    public static void main(String[] args) {

        System.out.println(isValid("([)]"));
    }
}
