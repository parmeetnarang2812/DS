/* 1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it. */

/* 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<Character> ostack = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ostack.push(ch);
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ostack.size() > 0 && ostack.peek() != '(' && precedence(ostack.peek()) >= precedence(ch)) {
                    conversion(ostack, pre, post);
                }
                ostack.push(ch);
            } else if (ch == ')') {
                while (ostack.size() > 0 && ostack.peek() != '(') {
                    conversion(ostack, pre, post);
                }
                ostack.pop(); // removing the opening bracket
            }
        }
        while (ostack.size() > 0) {
            conversion(ostack, pre, post);
        }
        System.out.println(post.peek());
        System.out.println(pre.peek());
    }

    static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else {
            return 2;
        }
    }

    static void conversion(Stack<Character> ostack, Stack<String> pre, Stack<String> post) {
        char op = ostack.pop();

        String preval2 = pre.pop();
        String preval1 = pre.pop();
        pre.push(op + preval1 + preval2);

        String postval2 = post.pop();
        String postval1 = post.pop();
        post.push(postval1 + postval2 + op);
    }

}
*/