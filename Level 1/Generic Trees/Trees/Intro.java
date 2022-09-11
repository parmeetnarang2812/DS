/* package Trees;
import java.util.*;

public class Intro {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> " ;
        for(Node child : node.children) {
            str += child.data + ", " ;
        }
        str += ".";
        System.out.println(str);

        for(Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node node) {
        int sz = 0;
        for(Node child : node.children) {
            int csz = size(child);
            sz += csz;
        }
        sz+=1;
        return sz;
    }

    public static int maximum(Node node) {
        int max = 0;
        for(Node child : node.children) {
            int cmax = maximum(child);
            max = Math.max(max, cmax);
        }
        max = Math.max(max, node.data);
        return max;
    }

    public static int height(Node node) {
        // ht = 0  =>  no. of nodes(deepest node)
        int ht = -1;    // no. of edges(depth)
        for(Node child : node.children) {
            int ch = height(child);
            ht = Math.max(ch, ht);
        }
        ht += 1;
        return ht;
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

        // display(root);
        // System.out.print(size(root));
        // System.out.print(maximum(root));
        System.out.print(height(root));
    }
}
 */