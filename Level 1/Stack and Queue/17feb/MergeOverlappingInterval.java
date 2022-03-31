/* 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public int compareTo(Pair o) {
            if (this.start != o.start) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length]; //creating a new array witj same values
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair();
            pairs[i].start = arr[i][0];
            pairs[i].end = arr[i][1];
        }

        Arrays.sort(pairs); //sorting the pairs in the array

        Stack<Pair> st = new Stack<Pair>();
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                st.push(pairs[i]);
            } else {
                Pair top = st.peek();
                Pair curr = pairs[i];

                if (curr.start > top.end) {
                    st.push(pairs[i]);
                } else {
                    top.end = Math.max(top.end, curr.end);
                }
            }
        }

        Stack<Pair> res = new Stack<>();    //reversing the stack
        while (st.size() > 0) {
            res.push(st.pop());
        }
        while (res.size() > 0) {
            Pair rp = res.pop();
            System.out.println(rp.start + " " + rp.end);
        }
    }

} 
*/