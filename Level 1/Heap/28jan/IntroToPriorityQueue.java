import java.io.*;
import java.util.*;

public class IntroToPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(28);
        pq.add(55);
        pq.add(34);
        pq.add(63);
        pq.add(12);

        System.out.println(pq.peek());
        pq.remove();

        System.out.println(pq.peek());
        pq.remove();

        System.out.println(pq.peek());
        pq.remove();

        System.out.println(pq.peek());
        pq.remove();

        System.out.println(pq.peek());
        pq.remove();

        System.out.println(pq.peek());
        pq.remove();

        System.out.println("-------");
        
        int[] arr = { 10, 34, 28, 12, 23, 45 };
        for (int val : arr) {
            pq.add(val);
        }
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
