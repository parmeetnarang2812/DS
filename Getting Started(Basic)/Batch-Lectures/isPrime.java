import java.util.*;

public class isPrime {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    for (int i = 1; i <= t; i++) {
      int n = scn.nextInt();
      boolean isPrime = true;
      int div = 2;
      while (div * div <= n) {
        int rem = n % div;
        if (rem == 0) {
          isPrime = false;
          break;
        }
        div++;
      }
      if (isPrime == true) {
        System.out.println("prime");
      }
      else {
        System.out.println("not prime");
      }
    }
    scn.close();
  }
}