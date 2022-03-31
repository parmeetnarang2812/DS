import java.util.*;

public class allPrimeInRange{
    public static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
    public static void printAllPrimesInRange(int low, int high){
        for(int i=low; i<=high; i++)
        {
            if(isPrime(i))
            System.out.println(i);
        } 
    }
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        printAllPrimesInRange(low,high);
        scn.close();
    }
}