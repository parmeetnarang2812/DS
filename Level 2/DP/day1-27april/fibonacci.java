import java.util.Scanner;

public class fibonacci {

    public static void display(int[] dp) {
        for(int ele : dp) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for(int[] d : dp) {
            display(d);
        }
    }

    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacci_mem(int n, int[] dp) {
        if(n <= 1) {
            return dp[n] = n;
        }
        if(dp[n]!=0) {
            return dp[n];
        }
 
        return dp[n] = fibonacci_mem(n-1, dp) + fibonacci_mem(n-2, dp);
  
    }

    public static int fibonacci_tab(int N, int[] dp) {
        for(int n=0; n<=N; n++) {
            if(n <= 1) {
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n-1] + dp[n-2];
        }
        return dp[N];
    }

    // two pointer approach
    public static int fibonacci_optimization(int N) {
        int a=0, b=1;    
        for(int n=0; n<N; n++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int fib = fibonacci(n);
        // System.out.println(fib);
        
        // int fib = fibonacci_mem(n, new int[n+1]);
        // System.out.println(fib);

        // int[] dp = new int[n+1];
        // int fib = fibonacci_tab(n, dp);
        // System.out.println(fib);
        // display(dp);

        int fib = fibonacci_optimization(n);
        System.out.println(fib);
    }
} 