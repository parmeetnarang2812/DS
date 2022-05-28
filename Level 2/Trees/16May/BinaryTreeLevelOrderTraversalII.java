/*                  107. Binary Tree Level Order Traversal II - Medium

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 
*/

/* my leetcode soln
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode part = new TreeNode(Integer.MAX_VALUE);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (q.size() > 0) {
            q.add(part);
            List<Integer> list = new ArrayList<>();
            while (q.size() > 0 && q.peek().val != Integer.MAX_VALUE) {
                TreeNode temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                list.add(temp.val);
            }
            result.add(list);
            q.remove();
        }

        Collections.reverse(result);
        return result;
    }
} 
*/