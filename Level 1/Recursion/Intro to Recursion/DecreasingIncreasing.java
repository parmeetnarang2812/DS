import java.util.*;
public class DecreasingIncreasing {
    public static void pDI (int n) {
        if(n==0){      
            return 1;
        }
        System.out.println(n);
        pDI(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pDI(n);
    }
}

/*
    output
    3
    3
    2
    1
    1
    2
    3
*/    