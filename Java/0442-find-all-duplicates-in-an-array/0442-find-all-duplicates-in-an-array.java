// https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public static List<Integer> findDuplicates(int[] nums) {

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

        ArrayList<Integer> list = new ArrayList<>();

        // Incorrect positions contain duplicate numbers
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                list.add(nums[index]);
            }
        }

        return list;
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
    2. Some numbers appear twice
    3. Find all duplicate numbers without using extra space
*/

/*
    Idea / Approach :
        Place every number at its correct index using Cyclic Sort
        Duplicate values cannot be placed because their correct position already contains the same value
        After sorting, every incorrect position stores a duplicate number
*/