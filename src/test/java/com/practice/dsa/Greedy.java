package com.practice.dsa;

import java.util.Arrays;

public class Greedy {

    public static boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) return false;

            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0;
        int r = 0;
        int count = 0;
        ;

        while (l < g.length && r < s.length) {

            if (g[l] <= s[r]) {
                count++;
                r++;
                l++;
            } else if (g[l] > s[r]) r++;
        }
        return count;

    }

    public boolean lemonadeChange(int[] bills) {

        int a = 0;
        int b = 0;


        for (int i = 0; i < bills.length; i++) {

            if (bills[i] == 5) a++;

            if (bills[i] == 10) {

                if (a == 0) return false;
                else {
                    a--;
                    b++;
                }
            }

            if (bills[i] == 20) {

                if (b > 0 && a > 0) {
                    b--;
                    a--;
                } else if (a >= 3) {
                    a -= 3;
                } else {
                    return false;
                }


            }


        }


        return true;

    }


    public static void main(String[] args) {

        int ar[] = {2, 3, 0, 1, 4};

        System.out.println(canJump(ar));
        Arrays.sort(ar);

    }
}
