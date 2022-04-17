import java.io.*;
import java.util.*;

public class FloodFillWithJumps {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "", vis);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] vis) {
        
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        String[] dirS = {"t", "l", "d", "r"};

         if(sr >= maze.length || sc >= maze[0].length || sr < 0 || sc < 0 || maze[sr][sc] == 1 || vis[sr][sc]==true){
            return;
        }

        if(sr==maze.length-1 && sc==maze[0].length-1) {
            System.out.println(asf);
            return;
        }

        vis[sr][sc]=true;
        for(int d=0; d<dir.length; d++) {
            for(int jump=1; jump <= Math.max(maze.length-1, maze[0].length-1); jump++) {
                int r = sr + jump*dir[d][0];
                int c = sc + jump*dir[d][1];
                floodfill(maze, r, c, asf+dirS[d], vis);
            }
        }
        vis[sr][sc]=false;
    }
}