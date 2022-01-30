import java.io.*;
import java.util.*;

public class PowerLogarithmic {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int n = scn.nextInt();
    int xp = power(x, n);
    System.out.println(xp);
  }

  public static int power(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int xpd2 = power(x, n / 2);
    int xp = xpd2 * xpd2;
    if (n % 2 != 0) {
      xp *= x;
    }
    return xp;
  }

}