import java.util.*;
public class anyBaseToDec{
    public static Scanner scn = new Scanner(System.in);
    public static int anyBaseTodecimal(int num, int base){
        int dn=0; //decimalno.
        int pow=1; //base's power
        while(num!=0){
            int rem = num % 10;
            num /= 10;
            dn += rem * pow;
            pow *= base;
        }
        return dn;
    }
    public static void main(String args[]){
        int n=scn.nextInt();
        int b=scn.nextInt();
        int d=anyBaseTodecimal(n,b);
        System.out.print(d);
    }
}