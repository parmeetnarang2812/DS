class Solution {
    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        // return friends_recursive(n);
        // return friends_mem(n, dp);
        return friends_tab(n, dp);
    }

    public long friends_tab(int N, long[] dp) {
        long mod = (long) 1e9 + 7;
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = 1;
                continue;
            }
            dp[n] = (dp[n - 1] % mod + (dp[n - 2] % mod * (n - 1)) % mod) % mod;
        }

        return dp[N];
    }

    public long friends_mem(int n, long[] dp) {
        if (n <= 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n] % 1000000007;
        }

        long single = friends_mem(n - 1, dp);
        long pair = friends_mem(n - 2, dp) * (n - 1);
        return dp[n] = (single + pair) % 1000000007;

    }

    public long friends_recursive(int n) {
        if (n <= 1) {
            return 1;
        }

        long single = friends_recursive(n - 1);
        long pair = friends_recursive(n - 2) * (n - 1);
        return single + pair;
    }
}