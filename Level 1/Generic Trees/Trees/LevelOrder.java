package Trees;
import java.util.*;

public class LevelOrder {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        
        // remove, print , add children
        while(q.size()>0) {
            node = q.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children) {
                q.add(child);
            }
        }
        System.out.print(".");
    }

    public static void levelOrderLW(Node node) {
        Queue<Node> mq = new ArrayDeque<>();    // main queue
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();    // child queue

        // remove, print , add children
        while(mq.size()>0) {
            node = mq.remove();
            System.out.print(node.data + " ");

            for(Node child : node.children) {
                cq.add(child);
            }

            if(mq.size()==0) {
                mq=cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    
    public static void levelOrderLwZigZag(Node node) {
        Stack<Node> ms = new Stack<>();    // main Stack
        ms.push(node);
        Stack<Node> cs = new Stack<>();    // child Stack
        int level=1;

        // remove, print , add children
        while(ms.size()>0) {
            node = ms.pop();
            System.out.print(node.data + " ");

            if(level%2==1) {
                for(int i=0; i<node.children.size(); i++) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            else {
                for(int i=node.children.size()-1; i>=0; i--) {
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }

            if(ms.size()==0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }    
    }
    
    public static void main(String[] args) {
        int[] arr = {10,20,-1,30,50,-1,60,-1,-1,40,-1};
        
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

        levelOrderLwZigZag(root);
    }
}
