// javac Intro.java && java Intro
// Display 2d array 

import java.util.*;
public class Intro{
    public static void main(String[] args){
        
        Scanner scn = new Scanner(System.in);
        int [][]arr = new int[3][3];

        arr[0][0] = 11;
        arr[0][1] = 12;
        arr[0][2] = 13;

        arr[1][0] = 21;
        arr[1][1] = 22;
        arr[1][2] = 23;

        arr[2][0] = 31;
        arr[2][1] = 32;
        arr[2][2] = 33;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        scn.close();
    }
}