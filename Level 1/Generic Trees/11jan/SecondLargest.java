import java.io.*;
import java.util.*;

public class SecondLargest {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    
    static int largest = Integer.MIN_VALUE;
    static int slargest = Integer.MIN_VALUE;
    
    // int size = 0;

    public static void secondLargest1(Node node) {
        // every node will come here
        if (node.data >= largest) {
            slargest = largest;
            largest = node.data;
        }
        else if (node.data > slargest) {
            slargest = node.data;
        }

        for (Node child : node.children) {
            secondLargest1(child);
                }

    }

    public static class HeapMover {
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
    }

    public static void secondLargest2(Node node, HeapMover mover) {
        // every node will come here
        if (node.data >= mover.largest) {
            mover.slargest = mover.largest;
            mover.largest = node.data;
        }
        else if (node.data > mover.slargest) {
            mover.slargest = node.data;
        }

        for (Node child : node.children) {
            secondLargest2(child, mover);
                }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        secondLargest1(root);
        System.out.println("Second Largest = " + slargest);
        System.out.println("Largest = " + largest);

        System.out.println("-------------------------");

        HeapMover mover = new HeapMover();
        secondLargest2(root, mover);
        System.out.println("Second Largest = " + mover.slargest);
        System.out.println("Largest = " + mover.largest);
    }

}


/*
input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

output
Second Largest = 50      
Largest = 60
-------------------------
Second Largest = 50      
Largest = 60
*/