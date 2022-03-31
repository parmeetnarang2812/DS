/* 
import java.io.*;
import java.util.*;

public class Main {

    public static int fibonacci(int n, int[] arr) { // memoization
        if (n == 0 || n == 1) { //base case
            return n;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        int fm1 = fibonacci(n - 1, arr);
        int fm2 = fibonacci(n - 2, arr);
        int fn = fm1 + fm2;

        arr[n] = fn;    //storing the fibonacci of n in arr[n]

        return fn;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int fn = fibonacci(n, new int[n + 1]);  //size is +1 bcz we are storing fib of n in n itself, say fib(1) in idx 1 of array.
        System.out.println(fn);
    }

} 
*/