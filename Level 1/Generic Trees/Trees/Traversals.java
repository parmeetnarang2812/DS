package Trees;
import java.util.*;

public class Traversals {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void traversal(Node node) {
        // node pre area
        System.out.println("Node pre " + node.data);

        for(Node child : node.children) {
            // edge pre area
            System.out.println("Edge pre " + node.data+ "--" + child.data);
            traversal(child);
            // edge post area
            System.out.println("Edge post " + node.data+ "--" + child.data);
        }

        // node post area
        System.out.println("Node post " + node.data);
    }
    
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        
        Node root = null;
        Stack<Node> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            if(arr[i]==-1) {
                st.pop();
            }
            else{
                Node temp = new Node();
                temp.data = arr[i];

                if(st.size()>0) {
                    st.peek().children.add(temp);
                }
                else {
                    root = temp;
                }

                st.push(temp);
            }
        }

        traversal(root);
    }
}
