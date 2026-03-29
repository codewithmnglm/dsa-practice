package com.practice.dsa;

import java.util.*;

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

    public int jump2LC45(int[] nums) { // re do it once again.

        int far = 0;
        int cur = 0;
        int jump = 0;


        for (int i = 0; i < nums.length - 1; i++) {

            far = Math.max(far, i + nums[i]);

            if (i == cur) {
                jump++;
                cur = far;
                if (far >= nums.length - 1) return jump;

            }


        }
        return jump;

    }


    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int profitSum = 0;
        int maxd = Integer.MIN_VALUE;
        int jb = 0;

        for (int i = 0; i < deadline.length; i++) {
            maxd = Math.max(maxd, deadline[i]);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < profit.length; i++) map.put(profit[i], deadline[i]);

        for (int i = 0; i < maxd - 1; i++) {

            profitSum = profitSum + findValueFromHashMap(map, i + 1);
            jb = i;
        }


        ArrayList<Integer> al = new ArrayList<>();
        al.add(jb + 1);
        al.add(profitSum);


        return al;

    }

    public static int findValueFromHashMap(Map<Integer, Integer> map, int key) {

        int num = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= key) {
                num = Math.max(num, entry.getKey());
            }
            map.put(entry.getKey(), entry.getValue() - 1);
            if (entry.getValue() == 0) map.remove(entry.getKey());


        }


        return num;
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);


        int sum=0;
        int i=0;

        while(k>0 && i<nums.length){

            if(nums[i]<0) {
                nums[i]=nums[i] * -1;
                k--;
                i++;
            }

            else if(nums[i]==0) {
                i++;
                k--;
            }


            else if(nums[i]>0 && k%2==0){
                break;

            }

            else if(nums[i]>0 && k%2!=0){
                nums[i]=nums[i] * -1;
                break;
            }

        }

        for(int j=0;j<nums.length;j++) sum= sum+nums[j];



        return sum;



    }

    public static void main(String[] args) {

        int ar[] = {2,-3,-1,5,-4};

        //System.out.println(canJump(ar));
        //Arrays.sort(ar);

      //  int[] deadline = {3, 1, 2, 2};
        int[] nums = {-2,5,0,2,-2};


        System.out.println(largestSumAfterKNegations(nums, 3));


        //System.out.println(jobSequencing(deadline, profit));


    }
}
