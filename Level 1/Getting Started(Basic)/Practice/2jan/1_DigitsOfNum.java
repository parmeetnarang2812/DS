import java.util.*;
    
    public class Main{
    
    public static void main(String[] args) {
      // write your code here 
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int div = 1;
      int temp = n;
      while(temp>=10) {     // first divisor calculation
          temp/=10;
          div*=10;
      }
      while(div>=1) {       // print digits logic
          int quo = n/div;
          int rem = n%div;
          System.out.println(quo);
          n=rem;
          div/=10;
      }
     }
    }