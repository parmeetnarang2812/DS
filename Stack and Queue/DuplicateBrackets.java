import java.util.*;

public class DuplicateBrackets {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    System.out.print(true);
                    return;
                } else {
                    while (st.size() != 0 && st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        System.out.print(false);
    }

}