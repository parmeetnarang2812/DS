// my code using functions
import java.util.*;
public class rotateDigits{
    public static int countDigits(int n){
        int count=0;
        while(n!=0){
            int q=n/10;
            n=q;
            count++;
        }
        return count;
    } 
    public static void RotateDigits(int n, int k){
        int digits = countDigits(n);
        int div=1;
        int mul=1;
        k=k%digits;
        if(k<0){
            k=k+digits;
        }
        for(int i=1; i<=digits; i++){
            if(i<=k){
                div *= 10;
            }
            else{
                mul *= 10;
            }
        }
        int q=n/div;
        int r=n%div;
        int ans=r*mul+q;
        System.out.print(ans);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        RotateDigits(n,k);
        scn.close();
    }
}

// Sir's Code
/*
import java.util.*;

public class Main {

  public static void main(String[] args) {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();

    int nod = 0;
    int temp = n;
    while(temp != 0){
        temp = temp / 10;
        nod++;
    }
    k=k%nod;
    int div = 1;
    int mult = 1;
    for(int i = 1; i <= nod; i++){
        if(i <= k){
            div = div * 10;
        } else {
            mult = mult * 10;
        }
    }

    int q = n / div;
    int r = n % div;
    int ans = r * mult + q;
    System.out.println(ans);

  }
}
*/