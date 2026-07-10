// https://leetcode.com/problems/search-in-rotated-sorted-array/

/*
    Approach ->
        1. Find the pivot element index
        2. If pivot is not found, the array is not rotated
        3. Apply binary search on the entire array
        4. If pivot is found, check whether the target is the pivot element
        5. Otherwise, determine in which sorted half the target lies
        6. Apply binary search on the corresponding sorted half
*/

class Solution {
    public static int findPivotIdx(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Four cases to check

            // Case 1 Mid itself is the pivot
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Case 2 Element before mid is the pivot
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            // Case 3 Left half is sorted so pivot must be in the right half
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            }

            // Case 4 Right half is sorted so pivot must be in the left half
            else {
                end = mid - 1;
            }
        }

        // Pivot not found means the array is not rotated
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    public static int search(int[] nums, int target) {

        int pivotIdx = findPivotIdx(nums);

        // If pivot is not found, the array is not rotated
        if (pivotIdx == -1) {

            // Perform normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        // If the pivot element itself is the target
        if (nums[pivotIdx] == target) {
            return pivotIdx;
        }

        // If the target lies in the left sorted half
        if (target >= nums[0] && target <= nums[pivotIdx]) {
            return binarySearch(nums, target, 0, pivotIdx);
        }

        // Otherwise search in the right sorted half
        return binarySearch(nums, target, pivotIdx + 1, nums.length - 1);
    }

}