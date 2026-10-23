// https://leetcode.com/problems/maximum-k-to-sort-a-permutation

class Solution {
    
    public static int sortPermutation(int[] nums) {

        int ans = -1;

        for (int i = 0; i < nums.length; i++) {

            // Only misplaced values restrict the possible k
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }

        return Math.max(ans, 0);
    }
}

/*
    Approach:

    - Traverse the permutation and identify misplaced values
    - Compute the bitwise AND of all misplaced values to find the maximum valid k
    - Initialize ans to -1 because all its bits are set
    - Return 0 if the array is already sorted or the AND becomes 0

    Time Complexity: O(n)
    Space Complexity: O(1)

    Important:
    - Bitwise AND (&) preserves only bits set in both operands
    - A misplaced value must be considered because it needs to move to its correct index
    - The initial value -1 acts as the identity for bitwise AND
*/