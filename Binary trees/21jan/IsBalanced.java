import java.io.*;
import java.util.*;

public class IsBalanced {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  // approach 1 - using static variable
  // treeIsBal here
  static boolean isBal = true;
  public static int isBalanced1(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = isBalanced1(node.left);
    int rh = isBalanced1(node.right);
    int ht = Math.max(lh, rh) + 1;

    boolean nodeIsBal = Math.abs(lh - rh) >= 1;
    if (nodeIsBal == false) {
      isBal = false;
    }

    return ht;
  }

  // approach 2 - using Pair class to return two values at once
  static class BPair {
    int ht = -1;
    boolean isBal = true;
  }
  public static BPair isBalanced2(Node node) {
    if (node == null) {
      BPair bp = new BPair();
      bp.ht = -1;
      bp.isBal = true;
      return bp;
    }

    BPair lp = isBalanced2(node.left);
    BPair rp = isBalanced2(node.right);

    BPair returnp = new BPair();
    returnp.ht = Math.max(lp.ht, rp.ht) + 1;
    boolean nodeIsBal = Math.abs(lp.ht-rp.ht)<=1;
    returnp.isBal = (lp.isBal==true) && (rp.isBal==true) && (nodeIsBal==true);
    
    return returnp;
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);

    // isBalanced1(root);
    // System.out.println(isBal);
    
    BPair mp = isBalanced2(root);
    System.out.println(mp.isBal);
  }

}
