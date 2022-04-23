/*                              40. Combination Sum II - Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates 
where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output: 
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]

Example 2:
    Input: candidates = [2,5,2,1,2], target = 5
    Output: 
    [
    [1,2,2],
    [5]
    ]
 

Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
*/


/*  my leetcode soln
    recursive method
class Solution {
    private void combinationSum2(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            return;
        }

        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                combinationSum2(arr, tar - arr[i], i + 1, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
                prev = arr[i];
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        combinationSum2(arr, tar, 0, ans, smallAns);
        return ans;
    }

}
 */