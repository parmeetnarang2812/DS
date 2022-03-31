import java.util.*;
public class decToAnyBase{
    public static Scanner scn = new Scanner(System.in);
    public static int decimalToAnyBase(int num, int base){
        int dn=0; //decimalno.
        int pow=1; //ten's power
        while(num!=0){
            int rem = num % base;
            num /= base;
            dn += rem * pow;
            pow *= 10;
        }
        return dn;
    }
    public static void main(String args[]){
        int n=scn.nextInt();
        int b=scn.nextInt();
        int d=decimalToAnyBase(n,b);
        System.out.print(d);
    }
}