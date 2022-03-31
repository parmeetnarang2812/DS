import java.io.*;
import java.util.*;

public class FindAndNodeToRootPath {
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

  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }
    if (node.data == data) {
      return true;
    }
    boolean fil = find(node.left, data);
    if (fil == true) {
      return true;
    }
    boolean fir = find(node.right, data);
    if (fir == true) {
      return true;
    }
    return false;
  }

    //approach 2
//  public static boolean findData(Node node, int data) {
//         if (node == null)
//             return false;

//         if (node.data == data)
//             return true;

//         return findData(node.left, data) || findData(node.right, data);
//     }


  public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
    if (node == null) {
      return new ArrayList<>();
    }
    if (node.data == data) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(node.data);
      return list;
    }
    ArrayList<Integer> llist = nodeToRootPath(node.left, data);
    if (llist.size() > 0) {
      llist.add(node.data);
      return llist;
    }
    ArrayList<Integer> rlist = nodeToRootPath(node.right, data);
    if (rlist.size() > 0) {
      rlist.add(node.data);
      return rlist;
    }
    return new ArrayList<>();
  }

    //approach 2
    //helper fn
//   public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans) {
//         if (node == null)
//             return false;

//         if (node.data == data) {
//             ans.add(node);
//             return true;
//         }
//         boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
//         if (res)
//             ans.add(node);

//         return res;
//     }

    //actual fn
//     public static ArrayList<Node> nodeToRootPath(Node root, int data) {
//         ArrayList<Node> ans = new ArrayList<>();
//         nodeToRootPath(root, data, ans);
//         return ans;
//     }

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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
  }

}