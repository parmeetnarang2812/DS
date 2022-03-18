/* 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not
        // then print "none"
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                st.push(j); // i knows j, i can't be celebrity
            } else {
                st.push(i); // j knows i, j can't be celebrity
            }
        }

        int pc = st.pop(); // pc->potential celebrity - only val left in stack
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (i != pc) {
                if (arr[pc][i] == 1 || arr[i][pc] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(pc);
        } else {
            System.out.println("none");
        }
    }
} 
*/