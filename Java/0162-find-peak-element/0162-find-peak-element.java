// Mountain array properties:
// 1. Elements are unique (no duplicates).
// 2. Array first increases, reaches a peak, then decreases.
// Example: [0, 2, 5, 10, 7, 3, 1]

// Same problem : https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // Edge case
        // Only one element in array
        if (start == end) {
            return start; // or return end
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // We are on the descending part of the mountain
                // The peak could be at mid itself, so we cannot discard it
                // Search in the left half including mid
                // That's why we do end = mid instead of end = mid - 1
                end = mid;
            } else {
                // We are on the ascending part of the mountain
                // Since arr[mid + 1] > arr[mid], mid cannot be the peak
                // The peak must be somewhere to the right
                start = mid + 1;
            }
        }

        // At this point, start == end
        return start; // or return end as both are =
    }
}