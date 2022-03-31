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
        int k = Integer.parseInt(br.readLine());

        // code
        int[] ans = swm(a, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] swm(int[] arr, int k) {

        int[] ngr = new int[arr.length];
        ngr[arr.length - 1] = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            // pop all smaller elements
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            // check st size and update ans
            if (st.size() == 0) {
                ngr[i] = arr.length;
            } else {
                ngr[i] = st.peek();
            }
            // push current idx
            st.push(i);
        }

        int[] ans = new int[arr.length - k + 1];
        int j = 0;
        for (int i = 0; i < ans.length; i++) {
            if (j < i) {
                j = i;
            }
            while (ngr[j] < i + k) {
                j = ngr[j];
            }
            ans[i] = arr[j];
        }

        return ans;

    }
}
*/