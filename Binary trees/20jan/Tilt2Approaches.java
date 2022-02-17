import java.io.*;
import java.util.*;

public class Tilt2Approaches {
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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  // approach 1 - using static variable
  //treeTilt
  static int tilt = 0;
  public static int tilt1(Node node){
      if(node == null){
          return 0;
      }

      int lsum = tilt1(node.left);
      int rsum = tilt1(node.right);
      
      //nodeTilt
      int nodeTilt = Math.abs(lsum - rsum);
      tilt += nodeTilt;

      return lsum + rsum + node.data;
  }

// approach 2 - using Pair class to return two values at once
static class TPair{
    int tiltSum=0;
    int sum=0;
}
  public static TPair tilt2(Node node){
      if(node == null){
          TPair bp = new TPair();
          bp.sum=0;
          bp.tiltSum=0;
          return bp;
      }

      TPair lpair = tilt2(node.left);
      TPair rpair = tilt2(node.right);

      TPair returnPair = new TPair();
      returnPair.sum = lpair.sum + rpair.sum + node.data;
      int nodeTilt = Math.abs(lpair.sum - rpair.sum);
      returnPair.tiltSum += lpair.tiltSum + rpair.tiltSum + nodeTilt;

      return returnPair;
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

    // tilt1(root);
    // System.out.println(tilt);
    
    TPair tp = new TPair();
    tp=tilt2(root);
    System.out.println(tp.tiltSum);
  }

}