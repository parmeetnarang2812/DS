import java.util.*;
public class countDigits{
    public static void CountDigits(int n){
        int digits=0;
        while(n!=0){
            int quo = n/10;
            n=quo;
            digits++;
        }
        System.out.print(digits);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        CountDigits(n);
        scn.close();
    }
}