import java.util.*;

public class PalindromicSubstrings {
    // first print all substrings
    public static void printAllSubstrings(String str){
		for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String sub = str.substring(i , j);
                System.out.println(sub);
            }
        }
		
	}
    public static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))
                return false;    
                
                i++;
                j--;
        }    
            return true;
    }
    // now analyze for palindromicSubstrings
    public static void palindromicSubstrings(String str){
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String sub = str.substring(i, j);
                if(isPalindrome(sub)){
                    System.out.println(sub);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        scn.close();
        // printAllSubstrings(str);
        palindromicSubstrings(str);
    }
}        