package com.practice.dsa;

import java.util.*;

public class DynamicProgramming {

    public static int lengthOfLIS(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        int len = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                maxLen = maxLen + 1;
                max = nums[i];

            } else if (nums[i] > min) {


            } else {
                min = nums[i];

            }


        }

        return 1;
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

    public static String frequencySort(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) hm.put(c, hm.get(c) + 1);
            else hm.put(c, 1);
        }
        ArrayList<Character> list = new ArrayList<>(hm.keySet());
        list.sort((a, b) -> hm.get(b) - hm.get(a));
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            int freq = hm.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static int climbStairs(int n) {


        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs2(n, dp);


    }

    public static int climbStairs2(int n, int[] dp) {

        if (n <= 3) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = climbStairs2(n - 2, dp) + climbStairs2(n - 1, dp);
        return dp[n];

    }

    public static List<List<Integer>> generate(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] lst = new Integer[i + 1];
            Arrays.fill(lst, 1);
            ans.add(Arrays.asList(lst));
        }

        for (int i = 2; i < n; i++) {

            for (int j = 1; j < ans.get(i).size() - 1; j++) {

                List<Integer> subList = ans.get(i - 1);
                ans.get(i).set(j, subList.get(j - 1) + subList.get(j));
            }
        }
        return ans;
    }

    public static List<List<Integer>> generate2(int n) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] lst = new Integer[i + 1];
            Arrays.fill(lst, 1);
            ans.add(Arrays.asList(lst));
        }

        for (int i = 2; i < n; i++) {

            for (int j = 1; j < ans.get(i).size() - 1; j++) {

                List<Integer> subList = ans.get(i - 1);
                ans.get(i).set(j, subList.get(j - 1) + subList.get(j));
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);

        }

        return max;
    }

    public static int frogJump(int i, int[] arr, int cost) {

        if (i == arr.length - 1) {
            return cost;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;


        if (i + 1 < arr.length) {
            left = frogJump(i + 1, arr, cost + Math.abs(arr[i + 1] - arr[i]));
        }


        if (i + 2 < arr.length) {
            right = frogJump(i + 2, arr, cost + Math.abs(arr[i + 2] - arr[i]));
        }

        return Math.min(left, right);

    }

    public static int frogJumpDPMemoization(int i, int[] arr, int[] dp) {

        if (i == arr.length - 1) {
            return 0;
        }
        if (dp[i] != -1) return dp[i];

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;


        if (i + 1 < arr.length) {

            left = frogJumpDPMemoization(i + 1, arr, dp) + Math.abs(arr[i + 1] - arr[i]);
        }

        if (i + 2 < arr.length) {

            right = frogJumpDPMemoization(i + 2, arr, dp) + Math.abs(arr[i + 2] - arr[i]);
        }

        return dp[i] = Math.min(left, right);

    }

    public static int frogJumpDPTabulation(int[] arr) {

        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 20;

        for (int i = 2; i < len; i++) {

            dp[i] = Math.min(dp[i - 1] + Math.abs(arr[i] - arr[i - 1]), dp[i - 2] + Math.abs(arr[i] - arr[i - 2]));

        }

        return dp[len - 1];
    }

    public static int frogJumpKStepsTabulation(int[] arr, int k) {

        int len = arr.length;
        int[] dp = new int[len];

        dp[0] = 0;

        for (int i = 1; i < len; i++) {

            int a1 = 0, a2 = 0;

            a1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            if (i - k < 0) {
                a2 = dp[0] + Math.abs(arr[i] - arr[0]);
            } else {
                a2 = dp[i - k] + Math.abs(arr[i] - arr[i - k]);
            }

            dp[i] = Math.min(a2, a1);

        }
        return dp[len - 1];

    }

    public static int nonAdjacent(int[] nums) {
        int max = Integer.MIN_VALUE;

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = (i == 0) ? 2 : 0; j < len; j++) {

                if (i == len - 1) {
                    len = len - 1;
                    max = Math.max(max, nums[i] * nums[j]);
                } else if (j == i - 1 || j == i + 1 || j == i) continue;
                else {
                    max = Math.max(max, nums[i] * nums[j]);
                }

            }


        }


        return max;
    }

    public static int nonAdjacentTabulation(int[] nums) {
        int max = Integer.MIN_VALUE;

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {

            if (i - 2 > 0) max = Math.max(dp[i - 2] + nums[i], nums[i]);

            else max = Math.max(dp[i - 1], nums[i]);

            dp[i] = Math.max(dp[i - 1], nums[i]);

        }


        return max;
    }

    public int buyStocks1(int[] prices) {

        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = prices[0];
        int minPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < len; i++) {
            minPrice = Math.min(minPrice, dp[i - 1]);
            profit = Math.max(profit, prices[i] - minPrice);
            dp[i] = Math.min(prices[i], dp[i - 1]);

        }

        return Math.max(profit, 0);

    }

    public static int houseRob(int[] nums) {

        int len = nums.length;

        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return Math.max(dp[len - 1], dp[len - 2]);

    }

    public static int houseRob2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int money1 = funRob(nums, 0, n - 2);
        int money2 = funRob(nums, 1, n - 1);

        return Math.max(money1, money2);
    }

    private static int funRob(int[] nums, int s, int e) {
        int prevRob1 = 0;
        int prevRob2 = 0;

        for (int i = s; i <= e; i++) {
            int curr = Math.max(prevRob1, prevRob2 + nums[i]);
            prevRob2 = prevRob1;
            prevRob1 = curr;
        }
        return prevRob1;
    }

    public static void ninjaTraining(int[][] matrix) {

        int sum = 10;
        findMaxRoute(0, -1, matrix, sum);

    }

    public static void findMaxRoute(int day, int lastActivity, int[][] matrix, int sum) {
        // Base case: all days covered
        if (day >= matrix.length) {
            System.out.println("Total Merit Points = " + sum);
            return;
        }

        // Try all activities for current day
        for (int act = 0; act < matrix[day].length; act++) {
            if (act != lastActivity) { // ensure no consecutive repetition
                findMaxRoute(day + 1, act, matrix, sum + matrix[day][act]);
            }
        }
    }

    public static boolean isSubsetSum(int[] arr, int target) {


        return subSetK(0, arr, target);

    }

    public static boolean subSetK(int i, int[] arr, int target) {

        if (target == 0) return true;
        if (i == arr.length) return false;
        boolean take = subSetK(i + 1, arr, target - arr[i]);
        boolean notTake = false;
        if (target >= arr[i]) {
            notTake = subSetK(i + 1, arr, target);
        }

        return take || notTake;


    }

    public static boolean canPartition(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        printSubsequences(al2, 0, al, nums);
        HashSet<Integer> hs = new HashSet<>(al2);
        return al2.size() != hs.size();
    }

    public static void printSubsequences(List<Integer> al2, int i, List<Integer> al, int[] ar) {
        var sum = 0;
        if (i >= ar.length) {
            for (int p : al) sum = sum + p;
            al2.add(sum);
            return;
        }
        al.add(ar[i]);
        printSubsequences(al2, i + 1, al, ar);
        al.remove(al.size() - 1);
        printSubsequences(al2, i + 1, al, ar);


    }

    public static boolean isSubsetSum2(int[] nums, int k) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][k + 1];

        // Base Case: sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int target = 1; target <= k; target++) {

                // Not taking current number
                boolean notTake = dp[i - 1][target];

                // Taking current number (if possible)
                boolean take = false;
                if (nums[i - 1] <= target) {
                    take = dp[i - 1][target - nums[i - 1]];
                }

                dp[i][target] = take || notTake;
            }
        }

        return dp[n][k]; // Final answer
    }

    public static boolean isSubsetSum1D(int[] nums, int k) {
        boolean[] dp = new boolean[k + 1];

        // Base case: sum 0 is always possible
        dp[0] = true;

        // Process each number
        for (int num : nums) {
            // Traverse backwards to avoid overwriting values we still need
            for (int target = k; target >= num; target--) {
                if (dp[target - num]) {
                    dp[target] = true;
                }
            }
        }

        return dp[k];
    }

    public static int uniquePaths(int m, int n) {

        // int[][] dp = new int[m][n];
        // dp[0][0]=0;
        // Arrays.fill(dp, -1);
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1; // initialize dp with -1 (unvisited)
            }
        }
        //return findUniquePathMemoization(0, 0, 3,7,dp);
        return findUniquePathTabulation(3, 7, dp);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1; // initialize dp with -1 (unvisited)
            }
        }

        return findUniquePathTabulation2(2, 2, dp, obstacleGrid);

    }

    public static int findUniquePathMemoization(int i, int j, int m, int n, int[][] dp) {

        if (i == m - 1 && j == n - 1) return 1;
        // out of bounds
        if (i >= m || j >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int right = 0, down = 0;
        if (j < n - 1) right = findUniquePathMemoization(i, j + 1, m, n, dp);
        if (i < m - 1) down = findUniquePathMemoization(i + 1, j, m, n, dp);

        return dp[i][j] = right + down;

    }

    public static int findUniquePathTabulation(int m, int n, int[][] dp) {

        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int findUniquePathTabulation2(int m, int n, int[][] dp, int[][] arr) {

        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {
                if (arr[i][j] == 1) dp[i][j] = 0;
                else {
                    if (dp[i][j - 1] == -1) dp[i][j] = dp[i - 1][j];
                    else if (dp[i - 1][j] == -1) dp[i][j] = dp[i][j - 1];
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int j = 1; j < n; j++) dp[0][j] = grid[0][j] + dp[0][j - 1];

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        if (m == 1) return triangle.get(0).get(0);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                min = Math.min(triangle.get(i).get(j), min);

            }
            dp[i] = min + dp[i - 1];
        }

        return dp[m - 1];
    }

    public static int minimumTota2l(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];
        if (m == 1) return triangle.get(0).get(0);
        if(m==2) return triangle.get(0).get(0) + Math.min(triangle.get(1).get(1),triangle.get(1).get(0));
        int act=0;
        dp[0] = triangle.get(0).get(0);
        if(triangle.get(1).get(0)>triangle.get(1).get(1)){
            act =act+1;
            dp[1] = dp[0]+triangle.get(1).get(1);
        }
        else {
            //act =act;
            dp[1] = dp[0]+triangle.get(1).get(0);
        }
        for (int i = 2; i < m; i++) {

            if(triangle.get(i).get(act)>triangle.get(i).get(act+1)){
                act =act+1;
                dp[i]=dp[i-1]+ triangle.get(i).get(act+1);
            }

            else{
                act=act;
                dp[i]=dp[i-1]+ triangle.get(i).get(act);
            }

        }

        return dp[m - 1];
    }

    public static int minimumTotalTopDown2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1;i<m;i++){

            int len = triangle.get(i).size();
            for(int j=0;j<len;j++){

                if(j==0){
                    dp[i][j]= triangle.get(i).get(j)+ dp[i-1][j];
                }
                else if(j==len-1){
                    dp[i][j]=triangle.get(i).get(j)+ dp[i-1][j-1];
                }
                else dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans;
    }

    public static int minimumTotalTopDown(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];

        // base case (top element)
        dp[0][0] = triangle.get(0).get(0);

        // build dp row by row
        for (int i = 1; i < m; i++) {
            int rowSize = triangle.get(i).size();
            for (int j = 0; j < rowSize; j++) {
                if (j == 0) {
                    // first element in row -> can only come from directly above
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == rowSize - 1) {
                    // last element in row -> can only come from above-left
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    // middle elements -> min of above and above-left
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }

        // answer = min in last row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }
        return ans;
    }




    public static void main(String[] args) {


        int nums[] = {2, 1};
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(-1));
        //triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1,-1,-3));


        System.out.println(minimumTotalTopDown(triangle));


    }
}
