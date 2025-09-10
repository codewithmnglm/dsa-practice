package com.practice.dsa;

import java.util.HashMap;
import java.util.Map;

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
}
