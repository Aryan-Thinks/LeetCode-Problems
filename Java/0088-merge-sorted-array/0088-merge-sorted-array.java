// https://leetcode.com/problems/merge-sorted-array/

class Solution {

    /* Approach: (Not the optimal one but trying sorting algos)
        1. Copy all elements of nums2 into the empty positions of nums1.
        2. Sort the merged array using Bubble Sort.
        Time: O((m + n)²)
        Space: O(1) 
    */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // Copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        // Sort the merged array
        bubbleSort(nums1);
    }

    // Bubble Sort
    public static void bubbleSort(int[] nums) {

        boolean swapped;

        for (int i = 0; i < nums.length - 1; i++) {

            swapped = false;

            for (int j = 1; j < nums.length - i; j++) {

                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    swapped = true;
                }
            }

            // Stop if the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

}