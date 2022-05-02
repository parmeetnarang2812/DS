class Solution
{
    public long countFriendsPairings(int n) 
    {
        int[] dp = new int[n+1]; 
        //return friends_recursive(n);
        return friends_mem(n, dp);
    }
    
    public long friends_mem(int n, long[] dp) {
        if(n<=1) {
            return dp[n] = 1;
        }
        if(dp[n]!=0) {
            return dp[n]% 1000000007;
        }

        long single = friends_mem(n-1, dp);
        long pair = friends_mem(n-2, dp) * (n-1);
        return dp[n] = (single + pair)% 1000000007; 

    }
    public long friends_recursive(int n) {
        if(n<=1) {
            return 1;
        }

        long single = friends_recursive(n-1);
        long pair = friends_recursive(n-2) * (n-1);
        return single + pair; 
    }
}   