import java.util.*;

  public class oddEvenCounting{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = 8;
      int p=1;
      while(p<=n){
          int rem=p%2;
          if(rem==0){
              System.out.println(p + "is even");
          }
          else{
            System.out.println(p + "is odd");  
          }
          p++;
      }
      scn.close();
    }
  }