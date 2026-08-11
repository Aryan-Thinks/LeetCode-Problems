// https://leetcode.com/problems/maximum-subarray/

// Kaden's Algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];                // Initial values
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];              // currSum = currSum + nums[i]

            maxSum = Math.max(maxSum, currSum);   // Check max value

            if (currSum < 0) {
                currSum = 0;             // Updation
            }
        }

        return maxSum;
    }
}

/*
    Approach: Kadane's Algorithm

    - Keep track of the current subarray sum.
    - Update maxSum whenever a larger sum is found.
    - If currSum becomes negative, reset it to 0.
    - This helps find the maximum sum of a contiguous subarray.

    Complexity:
    Time: O(n)
    Space: O(1)
*/