/* 
//memoization

import java.io.*;
import java.util.*;

public class Main {

    static int coinChange(int[] coins, int tar) {
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int t = 1; t < dp.length; t++) {
            for (int coin : coins) {
                if (t - coin >= 0) {
                    dp[t] += dp[t - coin]; // adding subproblems to calcute the actual problem
                }
            }
        }
        return dp[tar];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int amt = scn.nextInt();
        System.out.println(coinChange(arr, amt));
    }
} 
*/