import java.io.*;
import java.util.*;

public class Diameter4Approaches {
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
  // Approach 1 => O(n) approach => travel & tweak approach
  static int dia=0; 
  public static int diameter1(Node node) {
    if(node==null){
      return -1;
    }
    int lh=diameter1(node.left);
    int rh=diameter1(node.right);
    int ht=Math.max(lh,rh)+1;
    if(lh+rh+2>dia){
      dia=lh+rh+2;
    }
    return ht;
  }
  // Approach 2 => O(n) approach
  static class DiaMover{
    int dia=0;
  }
  public static int diameter2(Node node,DiaMover dm){
    if(node==null){
      return -1;
    }
    int lh=diameter2(node.left,dm);
    int rh=diameter2(node.right,dm);
    int ht=Math.max(lh,rh)+1;
    if(lh+rh+2>dm.dia){
      dm.dia=lh+rh+2;
    }
    return ht;  

  }
  // Approach 3 => O(n^2) approach
  public static int diameter3(Node node){
    if(node==null){
      return 0;
    }  
    int lh=height(node.left);
    int rh=height(node.right);
    int rdist=lh+rh+2;
    int ld=diameter3(node.left);
    int rd=diameter3(node.right);
    int dia=Math.max(rdist,Math.max(ld,rd));
    return dia;
  }
  // Approach 4 => O(n) approach
  static class DiaPair{
    int ht=-1;
    int dia=0;
  }
  public static DiaPair diameter4(Node node){
    if(node==null){
      DiaPair bp=new DiaPair();
      bp.ht=-1;
      bp.dia=0;
      return bp;
    }
    DiaPair lp=diameter4(node.left);
    DiaPair rp=diameter4(node.right);
    DiaPair mp=new DiaPair();
    mp.dia=Math.max(lp.ht+rp.ht+2,Math.max(lp.dia,rp.dia));
    mp.ht=Math.max(lp.ht,rp.ht)+1;
    return mp;
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
        //1st Method
    // int diameter = 0;
    // diameter = diameter1(root);
    // System.out.println(dia);

        //2nd Method;
    // DiaMover dm=new DiaMover();
    // int diameter=diameter2(root,dm);
    // System.out.println(dm.dia);

        //3rd Method
    //System.out.println(diameter3(root));

        //4th Method
    DiaPair dm=new DiaPair();
    dm=diameter4(root);
    System.out.println(dm.dia);

  }

}