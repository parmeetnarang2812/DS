import java.util.*;

public class PriorityQueueConstructor {

public static class MyPriorityQueue {
    ArrayList<Integer> data;

    public MyPriorityQueue() {
      data = new ArrayList<>();
    }
    
    public MyPriorityQueue(int[] arr) {
    //   data = new ArrayList<>();
    //   for(int val: arr){
    //     add(val);
    // }
    
    //effecient
    //change it to add values in O(n) instead of O(nlogn)
      for(int val: arr){
          data.add(val);
      }
      
      for(int i = data.size() / 2 - 1; i >= 0; i--){    //nlogn->n
          downheapify(i);
      }
    }

    public void add(int val) {
      data.add(val);
      upheapify(data.size() - 1);
    }
    
    void upheapify(int i){
        if(i == 0){
            return;    
        }
        
        int pi = (i - 1) / 2;
        if(data.get(pi) > data.get(i)){
            swap(pi, i);
            upheapify(pi);
        }
    }

    public int remove() {
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      
      swap(0, data.size() - 1);
      int val = data.remove(data.size() - 1);
      
      downheapify(0);
      
      return val;
    }
    
    void downheapify(int i){
        int mini = i;
        
        int lci = 2 * i + 1;
        if(lci < data.size() && data.get(lci) < data.get(mini)){
            mini = lci;
        }
        
        int rci = 2 * i + 2;
        if(rci < data.size() && data.get(rci) < data.get(mini)){
            mini = rci;
        }
        
        if(mini != i){
            swap(i, mini);
            downheapify(mini);
        }
    }

    public int peek() {
      // write your code here
      if(data.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
    
    void swap(int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);
    }
  }

    public static void main(String[] args) throws Exception {
      int[] arr = {5, 15, 2, 22, 37, 92, 81, 47};
      MyPriorityQueue pq = new MyPriorityQueue(arr);
      
      while(pq.size() > 0){
          int val = pq.peek();
          System.out.print(val + " ");
          pq.remove();
      }
    }
}