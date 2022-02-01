import java.io.*;
import java.util.*;

public class SortKSortedArray {
    
    
    public static void kSortedArray(int[]arr, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();  
      int idx = 0;
      for(int val : arr) {
          pq.add(val);
          
          if(pq.size() > k) {
            arr[idx++] = pq.remove();  
          }
      } 
      
      while(pq.size() > 0) {
          arr[idx++] = pq.remove();
      }
      
      for(int val : arr) {
          System.out.println(val);
      }
    }
    
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      kSortedArray(arr, k);
   }

}