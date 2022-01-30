import java.util.*;

public class Factorial {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fn = factorial(n);
        System.out.println(fn);
    }

    public static int factorial(int n){
        if(n==0){
           return 1; 
        }

        int fnm1 = factorial(n-1);
        int fn = fnm1 * n;
        return fn;
    }

}

/*
    output
    5
    120
*/    