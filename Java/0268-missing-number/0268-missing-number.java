// https://leetcode.com/problems/missing-number/

class Solution {
    public int missingNumber(int[] nums) {

        int i = 0;

        while (i < nums.length) {
            
            // Array contains 0 so correctIndex = nums[i]
            int correctIndex = nums[i];

            // Number N has no valid index in the array, so skip it
            // If the current number is not at its correct position,
            // swap it with the number at its correct index.
            
            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {

                swap(nums, i, correctIndex);

            } else {
                 /* Current number is either:
                 1. Already at the correct position, or
                 2. Equal to N (cannot be placed).
                 Move to the next index. */
                
                i++;
            }
        }

        // Find the first index where value != index
        // That index is the missing number
        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != index) {
                return index;
            }
        }

        // If every index contains the correct value,
        // then the missing number is N
        return nums.length;
    }

    private void swap(int[] nums, int first, int second) {

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}