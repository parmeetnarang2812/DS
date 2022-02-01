import java.util.*;

public class PrintKLargestElements {
    
        //rajneesh sir method ->time & space both better (time is a bit more effecient here)
        //space is O(k) => as in pq elts are added are removed parallely
    // public static void printKLargest1(int[] arr, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for (int ele : arr) {
    //         pq.add(ele);
    //         if (pq.size() > k)
    //             pq.remove();
    //     }

    //     while (pq.size() != 0) {
    //         System.out.println(pq.remove());
    //     }
    // }
        
        //sumeet sir method
        //space is O(k) => as pq is filled with only 'k' no.of elements
    public static void printKLargest2(int[]arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            pq.add(arr[i]);
        }
        
        for(int i=k; i<arr.length; i++) {
            int val = pq.peek();
            if(val < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        
        while(pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k =scn.nextInt();
        // printKLargest1(arr, k);
        printKLargest2(arr, k);

        scn.close();
    }
}
