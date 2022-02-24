import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                } else if (st.peek() != '(') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            } else if (ch == '}') {
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                } else if (st.peek() != '{') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            } else if (ch == ']') {
                if (st.size() == 0) {
                    System.out.println(false);
                    return;
                } else if (st.peek() != '[') {
                    System.out.println(false);
                    return;
                } else {
                    st.pop();
                }
            }
        }
        if (st.size() != 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }

}