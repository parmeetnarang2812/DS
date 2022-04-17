// leetcode question -> this soln gives TLE on leetcode but done for recursion practice

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];
        return countPaths(maze, 0, 0, m-1, n-1);
    }
    public int countPaths(int[][]maze, int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc) {
            return 1;
        }
            
        int count = 0;
        int[][] dir = {{1,0}, {0,1}};   //down, right
        for(int d=0; d<dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<=dr && c<=dc)
                count += countPaths(maze, r, c, dr, dc);
        }
        
        return count;
    }
}