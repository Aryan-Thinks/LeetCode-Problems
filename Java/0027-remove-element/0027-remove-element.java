// https://leetcode.com/problems/remove-element/

class Solution {

    public static int removeElement(int[] nums, int val) {

        int writeIdx  = 0;

        // Traverse through the array and keep only elements
        // that are different from val
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[writeIdx ] = nums[i];
                writeIdx ++;
            }
        }

        return writeIdx;
    }
}


/*
    Approach:
    - Use two pointers/indexes:
        1. i -> traverses through the entire array
        2. writeIdx  -> points to the position where the next
           valid element should be placed
    - If nums[i] is not equal to val, copy it to nums[writeIdx ]
    - Increment writeIdx  after placing a valid element
    - At the end, writeIdx  represents the number of elements
      that are not equal to val
    - The first writeIdx  elements of nums contain the required
      result

    Time Complexity:
    - O(n), where n is the length of the array
    - Each element is visited exactly once

    Space Complexity:
    - O(1)
    - No extra array or data structure is used

    Important:
    - The order of the elements that are not equal to val is preserved
    - Elements after the first writeIdx  positions do not matter
      because LeetCode only checks the first k elements
*/
