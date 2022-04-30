class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        // return tribonacci_recursion(n);
        // return tribonacci_mem(n, dp);
        // return tribonacci_tab(n, dp);
        return tribonacci_optimization(n);
    }
    
    public int tribonacci_mem(int n, int[] dp) {
        // if(n==0) {
        //     return dp[n] = n;
        // }
        // if(n==1 || n==2) {
        //     return dp[n] = 1;
        // }
        if (n <= 2) {
            return dp[n] = (n == 0 ? 0 : 1);
        }

        if(dp[n]!=0) {
            return dp[n];
        }

        return dp[n] = tribonacci_mem(n-1, dp) + tribonacci_mem(n-2, dp) + tribonacci_mem(n-3, dp);
    }

    public int tribonacci_tab(int N, int[] dp) {
        for(int n=0; n<=N; n++) {
            // if(n==0) {
            //     dp[n] = n;
            //     continue;
            // }
            // else if(n==1 || n==2) {
            //     dp[n] = 1;
            //     continue;
            // }
            if (n <= 2) {
                dp[n] = (n == 0 ? 0 : 1);
                continue;
            }

            dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
        }

        return dp[N];
    }

    public int tribonacci_optimization(int N) {
        int a=0, b=1, c=1;
        for(int n=0; n<N; n++) {
            int sum = a+b+c;
            a=b; 
            b=c;
            c=sum;
        }

        return a;
    }


    public int tribonacci_recursion(int n) {
        if(n==0) {
            return n;
        }
        if(n==1 || n==2) {
            return 1;
        }

        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }

}