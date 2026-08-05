// https://leetcode.com/problems/first-missing-positive/

// This question does not explicitly state to use Cyclic Sort, but it
// hints at it by asking for an algorithm that runs in O(n) time and uses O(1) auxiliary space

/*
Approach:
    First, place every positive number at its correct index
    Ignore negative numbers, zeros, and numbers greater than the array length
    Then find the first index where the value is not equal to index + 1
*/

class Solution {
    public static int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; ) {

            // Since positive numbers start from 1, the correct index is value - 1
            int correctIdx = nums[i] - 1;

            // Ignore negative numbers, zero, and numbers outside the valid range
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {

                // Already at the correct position, so move to the next index
                i++;
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All positive numbers from 1 to n are present
        return nums.length + 1;
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}