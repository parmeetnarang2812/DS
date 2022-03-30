/*  memoization 
import java.io.*;
import java.util.*;

public class Main {

    public static int goldmine(int[][] arr) {

        int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];

        for (int sc = m - 1; sc >= 0; sc--) {
            for (int sr = n - 1; sr >= 0; sr--) {
                if (sc == m - 1) {
                    dp[sr][sc] = arr[sr][sc];
                    continue;
                }

                int maxGold = 0;
                for (int d = 0; d < dir.length; d++) { // getting coordinates here
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];

                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        maxGold = Math.max(maxGold, arr[sr][sc] + dp[r][c]); // calculating
                    }
                }
                dp[sr][sc] = maxGold;
            }
        }

        int max = 0;
        for (int r = 0; r < n; r++) {
            max = Math.max(max, dp[r][0]);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // rows
        int m = scn.nextInt(); // columns
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.print(goldmine(arr));
    }

} 
*/