import java.util.*;

public class MaxOfAnArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []arr = new int[n];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int max = maxOfArray(arr,0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        // base case is different else there would be a downtime for -ve values
        if(idx == arr.length-1){
            return arr[idx];
        }
        // misa -> max in small array
        int misa = maxOfArray(arr, idx+1);
        if(arr[idx]>misa){
            return arr[idx];
        }
        else{
            return misa;
        }
    }

}