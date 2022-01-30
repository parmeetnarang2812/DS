import java.util.*;

public class printDecreasing {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pd(n);
        scn.close();
    }

    public static void pd(int n){
        if(n==0){
            return;
        }
        System.out.println();
        System.out.println(n);
        pd(n-1);
    }

}
