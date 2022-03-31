/* import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        // dp[0]=0;
        // dp[1]=1;

        // int res = climb_mem(dp, n);
        // System.out.println(res);

        int res = climb_tab(n);
        System.out.println(res);

    }

    public static int climb_mem(int[] dp, int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = climb_mem(dp, n - 1) + climb_mem(dp, n - 2) + climb_mem(dp, n - 3);

    }

    public static int climb_tab(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
        }

        return dp[n];
    }

} */