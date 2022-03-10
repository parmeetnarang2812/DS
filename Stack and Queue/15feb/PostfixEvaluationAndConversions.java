/* 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Integer> vstack = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> infix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch >= '0' && ch <= '9') {
                vstack.push(ch - '0');
                pre.push(ch + "");
                infix.push(ch + "");
            } else {

                int v2 = vstack.pop();
                int v1 = vstack.pop();
                int res = operation(v1, v2, ch);
                vstack.push(res);

                String preval2 = pre.pop();
                String preval1 = pre.pop();
                pre.push(ch + preval1 + preval2);

                String inval2 = infix.pop();
                String inval1 = infix.pop();
                infix.push("(" + inval1 + ch + inval2 + ")");
            }
        }

        System.out.println(vstack.peek());
        System.out.println(infix.peek());
        System.out.println(pre.peek());
    }

    static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }

} 
*/