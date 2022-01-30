import java.util.*;
  
  public class Main{
      
  public static boolean isPrime(int n) {
      boolean IsPrime = true;
      int div = 2;
      while(div*div<=n) {
          int rem = n%div;
          if(rem==0){
              IsPrime=false;
              break;
          }
          div++;
      }
      return IsPrime;
  }      
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int t = scn.nextInt();
      for(int i=1; i<=t; i++) {
        int n = scn.nextInt();
        if(isPrime(n)) {
            System.out.println("prime");
        }
        else{
            System.out.println("not prime");
        }
      }
  
   }
  }