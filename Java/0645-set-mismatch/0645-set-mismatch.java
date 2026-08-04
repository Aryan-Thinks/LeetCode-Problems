// https://leetcode.com/problems/set-mismatch/description/

class Solution {
    public static int[] findErrorNums(int[] nums) {

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

        // First incorrect position gives duplicate and missing number
        for (int index = 0; index < nums.length; index++) {

            if (nums[index] != index + 1) {
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void swap(int[] nums, int first, int second) {

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

/*
    When to use / Preconditions

    1. Array contains numbers from 1 to n
    2. One number is duplicated and one number is missing
    3. Return both duplicate and missing numbers
*/

/*
    Idea / Approach :
        Place every number at its correct index using Cyclic Sort
        The duplicate cannot occupy its correct position because it already exists there
        The first incorrect position gives both the duplicate and the missing number
*/