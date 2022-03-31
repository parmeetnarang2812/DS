import java.io.*;
import java.util.*;

public class Substring {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> ss = gss(str);
        System.out.println(ss);
    }

    // E => gss(abc) = [..., ..c, .b., .bc, ] + [a.., a.c, ab., abc]
    // F => gss(bc) = [.., .c, b., bc]
    // EwF => gss(abc) = .+gss(bc) + a+gss(bc)
    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            String theSS = "";
            bres.add(theSS);
            return bres; // [""] with size 1, theSS.length == 0 
        }
        
        char ch = str.charAt(0); // abc -> a
        String ros = str.substring(1); // abc -> bc
        ArrayList<String> rres = gss(ros); // gss(bc) = [--, -c, b-, bc]
        ArrayList<String> mres = new ArrayList<>();
        
        for(String rstr: rres){
            mres.add(rstr);
        }
        // mstr = [---, --c, -b-, -bc]
        
        for(String rstr: rres){
            mres.add(ch + rstr);
        }
        // mstr = [---, --c, -b-, -bc] + [a--, a-c, ab-, abc]
        
        return mres;
    }

}