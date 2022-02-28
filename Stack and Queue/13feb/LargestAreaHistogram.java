/* 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        // code

        // left stack   //nsol
        int[] lb = new int[a.length];   //left boundary
        lb[0] = -1;

        Stack<Integer> ls = new Stack<>();
        ls.push(0);

        for (int i = 1; i < a.length; i++) {
            while (ls.size() > 0 && a[i] <= a[ls.peek()]) {
                ls.pop();   
            }
            if (ls.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = ls.peek();
            }

            ls.push(i);
        }

        //right stack   //nsor
        int[] rb = new int[a.length];   //right boundary
        rb[a.length - 1] = a.length;

        Stack<Integer> rs = new Stack<>();
        rs.push(a.length - 1);

        for (int i = a.length - 2; i >= 0; i--) {
            while (rs.size() > 0 && a[i] <= a[rs.peek()]) {
                rs.pop();
            }
            if (rs.size() == 0) {
                rb[i] = a.length;
            } else {
                rb[i] = rs.peek();
            }

            rs.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int ht = a[i];
            int area = ht * width;

            if (area > max) {
                max = area;
            }
        }

        System.out.println(max);

    }
} 
*/