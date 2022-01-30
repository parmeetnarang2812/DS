import java.util.*;

public class GetCommonElements1 {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for (int i = 0; i < arr2.length; i++) {
      arr2[i] = scn.nextInt();
    }

    System.out.println();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int val : arr1) {
        if(map.containsKey(val)==false) {
            map.put(val, 1);
        }
    }
    
    for(int val : arr2) {
        if(map.containsKey(val)==true) {
            System.out.println(val);
            map.remove(val);
        }
    }
    scn.close();
  }
}