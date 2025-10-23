package com.practice.dsa;

public class ArrayProblems {

    public static int findlargest(int[] arr, int i) {
        int max = Integer.MIN_VALUE;

        for (int j = i; j < arr.length; j++) {

            max = Math.max(max, arr[j]);

        }
        return max;


    }

    public int[] replaceElements(int[] arr) {

        if (arr.length == 1) return new int[]{-1};

        int[] res = new int[arr.length];

        res[arr.length - 1] = -1;

        for (int i = 0; i < arr.length - 1; i++) {

            res[i] = findlargest(arr, i + 1);

        }

        return res;

    }

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
        int i = 0, j = colors.length - 1;
        while (j > i) {

            if (colors[j] != colors[i]) {
                maxValue = Math.abs(i - j);
                break;
            } else if (colors[j - 1] != colors[i] || colors[j] != colors[i + 1]) {
                maxValue = Math.abs(i - j - 1);
                break;
            } else {
                i++;
                j--;
            }


        }

        return maxValue;

    }

    public static void longestOnesLC1004(int[] nums, int k) {

        int zeroCount;
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {

            zeroCount = 0;
            int count = 0;
            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) zeroCount++;

                if (zeroCount > k) break;

                count++;


            }
            maxCount = Math.max(maxCount, count);

        }

        System.out.println("maxCout " + maxCount);
    }

    public static int minimumSumSubarray(int[] nums, int l, int r) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

               /* int len = nums.length - i;
                if (len >= l && len <= r) {
                    sum = sum + nums[i];
                } else break;*/
                System.out.print("," + nums[j]);

            }
            // if (sum > 0) count++;
            System.out.println();

        }
        return count > 0 ? count : -1;

    }
    public void sortColors(int[] nums) {

        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        for (int i=0;i<nums.length;i++){

            if(nums[i]==0) zeroCount++;

            if(nums[i]==1) oneCount++;

            if(nums[i]==2) twoCount++;


        }

        for(int i=0;i<nums.length;i++){

            if(zeroCount>0){

                nums[i]=0;
                zeroCount--;

            }
            else if(oneCount>0){

                nums[i]=1;
                oneCount--;

            }
            else if(twoCount>0){

                nums[i]=2;
                twoCount--;

            }



        }

    }


    public static void main(String[] args) {

        int[] ar = new int[]{-2, 2, -3, 1};

        //System.out.println(maxDistance(ar));

        // System.out.println(maxScore(ar,3));
        // longestOnesLC1004(ar, 3);
        minimumSumSubarray(ar, 2, 3);
    }
}
