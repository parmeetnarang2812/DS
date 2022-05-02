class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        // return minCostClimbingStairs_recursion(n,cost);
        // return minCostClimbingStairs_mem(n,cost,dp);
        // return minCostClimbingStairs_tab(n,cost,dp);
        return minCostClimbingStairs_optimiztion(n, cost);
    }

    public int minCostClimbingStairs_optimiztion(int N, int[] cost) {
        int one = 0, two = 0;
        for (int i = 0; i < N; i++) {
            int current = Math.min(one, two) + cost[i];
            one = two;
            two = current;
        }
        return Math.min(one, two);
    }

    public int minCostClimbingStairs_tab(int N, int[] cost, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = cost[n];
                continue;
            }
            dp[n] = Math.min(dp[n - 1], dp[n - 2]) + (n == cost.length ? 0 : cost[n]);
        }
        return dp[N];
    }

    public int minCostClimbingStairs_mem(int n, int[] cost, int[] dp) {
        if (n <= 1) {
            return dp[n] = cost[n];
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int climb_nm1 = minCostClimbingStairs_mem(n - 1, cost, dp);
        int climb_nm2 = minCostClimbingStairs_mem(n - 2, cost, dp);
        return dp[n] = Math.min(climb_nm1, climb_nm2) + (n == cost.length ? 0 : cost[n]);
    }

    public int minCostClimbingStairs_recursion(int n, int[] cost) {
        if (n <= 1) {
            return cost[n];
        }

        int climb_nm1 = minCostClimbingStairs_recursion(n - 1, cost);
        int climb_nm2 = minCostClimbingStairs_recursion(n - 2, cost);
        return Math.min(climb_nm1, climb_nm2) + (n == cost.length ? 0 : cost[n]);
    }
}