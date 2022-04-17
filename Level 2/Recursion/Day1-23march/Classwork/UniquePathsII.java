// leetcode question -> this soln gives TLE on leetcode but done for recursion practice

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1) // start/end is blocked
            return 0;

        return countPaths(obstacleGrid, 0, 0, n - 1, m - 1);
    }
    
    public int countPaths(int[][]maze, int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc) {
            return 1;
        }
        
        maze[sr][sc]=1;
            
        int count = 0;
        int[][] dir = {{1,0}, {0,1}};   //down, right
        for(int d=0; d<dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<=dr && c<=dc && maze[r][c]==0)
                count += countPaths(maze, r, c, dr, dc);
        }
        maze[sr][sc]=0;
        return count;
    }
}