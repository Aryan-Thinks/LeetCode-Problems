// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // i is updated manually inside the loop
        for (int i = 0; i < nums.length; i = i) {

            // Correct index of current element
            int correctIdx = nums[i] - 1;

            // Place current element at its correct index
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                // Already placed or duplicate found
                i++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Incorrect positions represent missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
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
    2. Some numbers may be duplicated
    3. Find all missing numbers without using extra space
*/

/*
    Idea / Approach :
        Place every number at its correct index using Cyclic Sort
        Duplicate values automatically stop swapping since their correct position already contains the same value
        After sorting, every index having an incorrect value represents a missing number
*/