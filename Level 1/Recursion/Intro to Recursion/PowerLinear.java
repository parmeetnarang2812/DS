import java.util.*;

public class PowerLinear {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        int xp = power(x,n);
        System.out.println(xp);
    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        int xpm1 = power(x,n-1);
        int xp = x*xpm1;
        return xp;
    }

}