// wave display -> state of wakanda-1 
import java.util.*;

public class waveDisplay {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // rows
        int m = scn.nextInt(); // columns
        int[][] arr = new int[n][m];

        // input array elements
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        /*
         * wave display (upwards to downwards only) ---start from this for(int j=0;
         * j<arr[0].length; j++){ for(int i=0; i<arr.length; i++){
         * System.out.println(arr[i][j]); } }
         */

        // wave display(up to down, down to up) ---what question asks for
        for (int j = 0; j < arr[0].length; j++) {
            if (j % 2 == 0) { // even column -> towards down
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i][j]);
                }
            } else { // odd column -> towards up
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.println(arr[i][j]);
                }
            }
        }
        
        scn.close();
    }
}

/*
 * Terminal Output 3 4 11 12 13 14 21 22 23 24 31 32 33 34 11 21 31 32 22 12 13
 * 23 33 34 24 14
 */