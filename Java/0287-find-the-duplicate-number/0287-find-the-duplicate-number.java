// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public static int findDuplicate(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            // Correct index of current element
            int correctIndex = nums[i] - 1;

            // Place current element at its correct index
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                // Already placed or duplicate found
                i++;
            }
        }

        // Duplicate remains at the last position
        return nums[nums.length - 1];
    }

    public static void swap(int[] nums, int first, int second) {

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}


/*
    When to use / Preconditions

    1. Array contains n + 1 numbers
    2. Values are in the range 1 to n
    3. Exactly one number is duplicated
*/

/*
    Idea / Approach :
        Place every number at its correct index using Cyclic Sort
        Since one number is duplicated, one position can never be occupied by its correct value
        After sorting, the duplicate remains at the last position
*/