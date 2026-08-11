// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {

        // Edge case
        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int i = 0;

        // Start from second element
        for (int j = 1; j < nums.length; j++) {

            // If new unique element is found
            if (nums[j] != nums[i]) {

                // Move unique position forward
                i++;

                // Place new unique element
                nums[i] = nums[j];
            }
        }

        // i is last index of unique element, count = i + 1
        return i + 1;
    }
}

/*
    Approach: Two Pointer Approach

    - i points to the last unique element.
    - j scans the array from left to right.
    - If nums[j] is different from nums[i], move i forward
      and copy nums[j] to nums[i].
    - Return i + 1 as the number of unique elements.

    Complexity:
    Time: O(n)
    Space: O(1)
*/