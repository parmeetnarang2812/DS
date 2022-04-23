import java.io.*;
import java.util.*;

public class ShortestPath {

    public static class Pair {
        int len = (int)1e9; // used instead of Integer.MAX_VALUE to leave some buffer [infinity + 1 = -infinity; which is wrong]
        String str = "";
    }

    public static Pair shortestPath(int sr, int sc, int dr, int dc, int[][] mat, int[][] dir, String[] dirS) {
        if(sr==dr && sc==dc) {
            Pair bp = new Pair();
            bp.len = 0;
            return bp;
        }

        Pair ans = new Pair();
        mat[sr][sc]=1;

        for(int d=0; d<dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && c>=0 && r<=dr && c<=dc && mat[r][c]==0) {
                Pair recAns = shortestPath(r, c, dr, dc, mat, dir, dirS);
                if(recAns.len != (int)1e9  &&  recAns.len + 1 < ans.len) {
                    ans.len = recAns.len + 1;
                    ans.str = recAns.str + dirS[d];
                }
            }
        }
        mat[sr][sc]=0;
        return ans;
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();  // rows
        int m = scn.nextInt();  // cols
        int[][] mat = new int[n][m];
        
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        String[] dirS = {"R", "D", "L", "U"};

        Pair rp = shortestPath(0, 0, n-1, m-1, mat, dir, dirS);
        System.out.println(rp.str + " -> " + rp.len);
    }
}