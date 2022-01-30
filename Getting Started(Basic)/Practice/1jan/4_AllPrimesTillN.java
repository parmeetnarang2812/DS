import java.util.*;

public class Main{
    public static boolean isPrime(int n){
        boolean res = true;
        int div = 2;
        while(div*div<=n){
            int rem = n%div;
            if(rem==0){
                res=false;
                break;
            }
            div++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        
        for(int i=low; i<=high; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
}