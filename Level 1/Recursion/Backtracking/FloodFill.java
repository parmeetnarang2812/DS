import java.io.*;
import java.util.*;

public class Main {

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
        // method 1
    // public static void floodfill(int[][] maze, int sr, int sc, String asf) {
    //     if(sr == maze.length - 1 && sc == maze[0].length-1){
    //         System.out.println(asf);
    //         return;
    //     }
        
    //     if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1){
    //         return;
    //     }
        
    //     maze[sr][sc] = 1;
        
    //     floodfill(maze,sr-1,sc,asf+"t"); //up
    //     floodfill(maze,sr,sc-1,asf+"l"); //left
    //     floodfill(maze,sr+1,sc,asf+"d"); //down
    //     floodfill(maze,sr,sc+1,asf+"r"); //right
        
    //     maze[sr][sc] = 0;
    // }

        // method 2
    // public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] vis) {
    //     if(sr==maze.length-1 && sc==maze[0].length-1) {
    //         System.out.println(asf);
    //         return;
    //     }

    //     if(sr<0 || sc<0 || sr>=maze.length || sc>=maze[0].length || maze[sr][sc]==1 || vis[sr][sc]==true) {
    //         return;
    //     } 

    //     visited[sr][sc]=true;
    //     floodfill(maze, sr-1, sc, asf+"t", vis);
    //     floodfill(maze, sr, sc-1, asf+"l", vis);
    //     floodfill(maze, sr+1, sc, asf+"d", vis);
    //     floodfill(maze, sr, sc+1, asf+"r", vis);
    //     visited[sr][sc]=false;
    // }

    
}