import java.util.*;
public class printDigits{
    public static int divisorEqualDigit(int n){
        int div=1;
        int temp=n;
        while(temp>=10){
            temp /= 10;
            div *= 10;
        }
        return div;
    }
    public static void digitsOfNumber(int n){
        int div = divisorEqualDigit(n);
        while(div!=0){
            int q = n/div;
            int r = n%div;
            System.out.println(q);
            n=r;
            div /= 10;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        digitsOfNumber(n);
        scn.close(); 
    }
}