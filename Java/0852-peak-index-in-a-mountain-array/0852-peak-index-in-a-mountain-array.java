// Mountain array properties:
// 1. Elements are unique (no duplicates).
// 2. Array first increases, reaches a peak, then decreases.
// Example: [0, 2, 5, 10, 7, 3, 1]

// Same problem : https://leetcode.com/problems/find-peak-element/

class Solution {

    // Brute force -> O(n)
    public int peakIndexInMountainArray2(int[] arr) {

        int maxVal = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                ans = i;
            }
        }

        return ans;
    }

    // Optimized -> O(log(n))
    // Binary search
    public static int peakIndexInMountainArray(int[] arr) {
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
                // We are on the descending part of the mountain.
                // The peak could be at mid itself, so we cannot discard it.
                // Search in the left half including mid.
                // That's why we do end = mid instead of end = mid - 1.
                end = mid;
            } else {
                // We are on the ascending part of the mountain.
                // Since arr[mid + 1] > arr[mid], mid cannot be the peak.
                // The peak must be somewhere to the right.
                start = mid + 1;
            }
        }

        /*
        At this point, start == end.
        
        During every iteration, we eliminate the half of the array that
        cannot contain the peak.
        
        - If we are on the descending side, we keep mid because it could
        still be the peak.
        - If we are on the ascending side, we discard mid because we know
        a larger element exists on the right.
        
        As a result, the search space keeps shrinking while always
        containing the peak.
        
        When only one element remains, both start and end point to it.
        Since the peak was never removed from the search space, this
        remaining element must be the peak.
        
        Therefore, return start (or end, since both are equal).
        */

        return start; // or return end as both are =

    }

}