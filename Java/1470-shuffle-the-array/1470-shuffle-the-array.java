// https://leetcode.com/problems/shuffle-the-array/

public class Solution {

    public int[] shuffle(int[] nums, int n) {

        // Create a new array to store the shuffled result
        int[] ans = new int[2 * n];

        // Pointer for the result array
        int j = 0;

        // Pick one element from the first half
        // followed by one element from the second half
        for (int i = 0; i < n; i++) {
            ans[j++] = nums[i];       // x1, x2, x3, ...
            ans[j++] = nums[i + n];   // y1, y2, y3, ...
        }

        return ans;
    }
}