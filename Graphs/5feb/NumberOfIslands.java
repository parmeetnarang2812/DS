import java.io.*;

public class NumberOfIslands {

   public static void fillComp(int[][] arr, int i, int j, boolean[][] visited) {
         if(i<0 || i>=arr.length || j<0 || j>=arr[0].length) {
            return;
         }
         if(visited[i][j]==true || arr[i][j]==1) {
            return;
         }

         visited[i][j]=true;
         fillComp(arr, i+1, j, visited);
         fillComp(arr, i-1, j, visited);
         fillComp(arr, i, j+1, visited);
         fillComp(arr, i, j-1, visited);
      }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      boolean[][] visited = new boolean[m][n];
      int count = 0;
      for(int i=0; i<m; i++) {
         for(int j=0; j<n; j++) {
            if(visited[i][j]==false && arr[i][j]==0) {
               fillComp(arr, i, j, visited);
               count++;
            }
         }
      }
      System.out.print(count);
   }

}
