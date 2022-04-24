/*                                      46. Permutations - Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
    Input: nums = [0,1]
    Output: [[0,1],[1,0]]

Example 3:
    Input: nums = [1]
    Output: [[1]]

Constraints:
    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
*/


/*  my leetcode soln
    recursion method
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        permutations(ans, smallAns, nums, 0);
        return ans;
    }

    private int permutations(List<List<Integer>> ans, List<Integer> smallAns, int[] nums, int elementUsed) {

        if (elementUsed == nums.length) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > -11) {
                int val = nums[i];
                nums[i] = -11;
                smallAns.add(val);

                count += permutations(ans, smallAns, nums, elementUsed + 1);

                nums[i] = val;
                smallAns.remove(smallAns.size() - 1);
            }
        }
        return count;
    }

} 
*/