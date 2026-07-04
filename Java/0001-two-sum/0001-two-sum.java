// https://leetcode.com/problems/two-sum/

class Solution {

    // Approach:
    // 1. Check every unique pair of numbers.
    // 2. Return their indices if their sum equals the target.
    // Time: O(n²)
    // Space: O(1)

    public int[] twoSum(int[] nums, int target) {

        // Check every pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                // Found the required pair
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        // No valid pair found
        return new int[] { -1, -1 };
    }
}