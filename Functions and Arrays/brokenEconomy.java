import java.io.*;
import java.util.*;

public class brokenEconomy {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int []arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int low = 0;
    int high = arr.length - 1;
    int ceil = -1, floor = -1;
    int d = scn.nextInt();
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] < d) {
        floor = arr[mid];
        low = mid + 1;
      } else if (arr[mid] > d) {
        ceil = arr[mid];
        high = mid - 1;
      }
      else {
        ceil = arr[mid];
        floor = arr[mid];
        break;
      }
    }
    System.out.println();
    System.out.println(ceil);
    System.out.println(floor);
  }
}