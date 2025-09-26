package com.practice.dsa;

public class ArrayProblems {

    public static int maximumDifference(int[] nums) {

        int min = nums[0];
        int max = -1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > min) {
                max = Math.max(nums[i] - min, max);
                min = Math.min(nums[i], min);
            } else min = nums[i];


        }
        return max;

    }

    public static int maxDistance(int[] colors) {

        int maxValue = 0;
        int i=0,j=colors.length-1;
        while(j>i){

            if(colors[j]!=colors[i]) {
                maxValue= Math.abs(i-j);
                break;
            }
            else if(colors[j-1]!=colors[i] || colors[j]!=colors[i+1]) {
                maxValue= Math.abs(i-j-1);
                break;
            }
            else{
                i++;
                j--;
            }


        }

        return maxValue;

    }

    public static void main(String[] args) {

        int[] ar = new int[]{6,6,6,6,6,6,6,6,6,19,19,6,6};

        System.out.println(maxDistance(ar));
    }
}
