class Solution {

    /* Approach:
    1. Since the array is sorted, use Binary Search.
    2. Perform Binary Search twice:
       - First pass: Find the first occurrence of the target.
       - Second pass: Find the last occurrence of the target.
    3. Whenever the target is found:
       - Store the current index as a potential answer.
       - Move left to find the first occurrence.
       - Move right to find the last occurrence.
    4. If the target is not found, return {-1, -1}.
    
    Time Complexity: O(log n)
    Space Complexity: O(1)*/

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[] { -1, -1 };

        int start = searchIndex(nums, target, true);
        int end = searchIndex(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    // Returns the first or last occurrence of target.
    static int searchIndex(int[] nums, int target, boolean findStartIndex) {

        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // Target found.

                ans = mid; // Current candidate index.

                if (findStartIndex) {
                    end = mid - 1; // Continue searching left.
                } else {
                    start = mid + 1; // Continue searching right.
                }
            }
        }

        return ans;
    }

    // Brut force
    // Worst Case: O(n)
    // Space Complexity: O(1)

    /*
    public static int[] searchRange(int[] nums, int target) {
    int start = -1;
    int end = -1;
    
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            start = i;
            while (nums.length > i && nums[i] == target) {
                i++;
            }
            end = i - 1;
            break;
        }
    }
    
    return new int[] { start, end };
    }
    */

}
