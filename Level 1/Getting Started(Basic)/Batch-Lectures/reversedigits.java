import java.util.*;
public class reversedigits
{
    public static Scanner scn = new Scanner(System.in);
    public static void reverseDigits(int n)
    {
        while(n!=0)
        {
            int rem = n % 10;
            n = n / 10;
            System.out.println(rem);
        }

    }
    public static void main(String[] args)
    {
        int n = scn.nextInt();
        reverseDigits(n);
    }
}