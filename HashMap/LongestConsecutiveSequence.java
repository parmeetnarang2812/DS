import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        HashMap<Integer, Boolean> map = new HashMap<>();

        // loop1 declaring all the values as a start of sequence by assigning true
        for (int val : arr) {
            map.put(val, true);
        }

        // loop2 checking for only those values which are actually a start of sequence
        // //discarding the ones which are not by assigning false to them
        for (int val : arr) {
            if (map.containsKey(val - 1) == true) {
                map.put(val, false);
            }
        }

        int msp = 0; // max starting part of sequence
        int mlen = 0; // max length of sequence

        // loop3 checks for the longest consecutive sequence
        for (int val : arr) {
            if (map.get(val) == true) {
                int tsp = val; // temp start point
                int tlen = 1; // temp seq length

                while (map.containsKey(tsp + tlen) == true) {
                    tlen++;
                }

                if (tlen > mlen) {
                    msp = tsp;
                    mlen = tlen;
                }
            }
        }

        // loop4 prints the longest consecutive sequence
        for (int i = 0; i < mlen; i++) {
            System.out.println(msp + i);
        }
        
        scn.close();
    }
}