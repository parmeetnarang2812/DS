/*
import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }
        // method 1 -> front to back
    public static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        ans[0] = 1;
        st.push(0);

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - st.peek();
            }
            st.push(i);
        }
        return ans;
    }

        // method 2 -> back to front
    // public static int[] solve(int[] arr){
    //     int[] ans = new int[arr.length];
    //     Stack<Integer> st = new Stack<>();
        
    //     st.push(arr.length-1);
     
    //     for(int i=arr.length-2; i>=0; i--) {
    //       while(st.size()>0 && arr[st.peek()]<arr[i]) {
    //         int pidx = st.pop();
    //         ans[pidx] = pidx - i; 
    //       }
    //       st.push(i);
    //     }
     
    //     while(st.size()>0) {
    //       int pidx = st.pop();
    //       ans[pidx] = pidx + 1;
    //     }
        
    //     return ans;
    //   }

}

*/