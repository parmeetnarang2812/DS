import java.io.*;
import java.util.*;

public class IntroToArraylist {

    public static void main(String[] args) throws Exception {
        
        //    ArrayList<Integer> list; // declare
        //    list = new ArrayList<>(); // define
        ArrayList<Integer> list = new ArrayList<>(); 
        System.out.println(list.size() + " -> " + list); // 0 -> []
        
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list.size() + " -> " + list); // 3 -> [10, 20, 30]
        
        list.set(1, 200); // changes values, does not add a new value
        System.out.println(list.size() + " -> " + list); // 3 -> [10, 200, 30]
        
        list.add(1, 2000); // adds a new value, is different from set
        System.out.println(list.size() + " -> " + list); // 4 -> [10, 2000, 200, 30]
        
        int val = list.get(1); 
        System.out.println(val); // you will get 2000 (list[1] will not work)
        System.out.println(list.size() + " -> " + list); // 4 -> [10, 2000, 200, 30]
        
        list.remove(1); // deletes the value at index 1
        System.out.println(list.size() + " -> " + list); // 3 -> [10, 200, 30]
        
        for(int i = 0; i < list.size(); i++){
            int val1 = list.get(i);
            System.out.println(val1);
        }
        
        for(int val2: list){
            System.out.println(val2);
        }
       
       
    }

}