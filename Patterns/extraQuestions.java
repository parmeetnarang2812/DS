// pattern21
import java.util.*;
   public class p{
   public static void main(String[] args) {
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      int i,j;
      for(i=0;i<2*n-1;i++){
        int count=n;
        for(j=0;j<2*n-1;j++){
        if(i<=n-1){  
            System.out.print("*\t");
        //   if(j<i)
        //   count--;
        //   if(j>=2*n-2-i)
        //   count++;

        // }
        // else{
        //     System.out.print("*\t");
        //   if(j>=i)
        //   count++;
        //   if(j<2*n-2-i)
        //   count--;
        // }
      } System.out.print("\n"); 
      }
    }
   }

// pattern23
//    for n = 3
// Ques 3)
// *
// *1 *
// *1 2 1 *
// *1 *
// *
// Solution:-
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int t = (2*n)-1;
//         int digit = -1;
        
//         for(int i =1;i<=t;i++){
//             System.out.print("*");
//             int c = 1;
//             for(int j =1 ;j<=digit;j++){
//                System.out.print(c+" ");
//                if(j<=digit/2){
//                    c++;
//                }
//                else{
//                    c--;
//                }
               
//             }
//             if(i!=1 && i!=t){
//                 System.out.print("*");
//             }
            
//             if(i<=t/2){
//                 digit+=2;
//             }
//             else{
//                 digit-=2;
//             }
//             System.out.println();
//     }
    
// }
// }