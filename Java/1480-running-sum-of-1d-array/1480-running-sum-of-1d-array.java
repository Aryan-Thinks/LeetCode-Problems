class Solution {
    public int[] runningSum(int[] nums) {

        // Start from the second element
        // Because the first element is already its own running sum
        for (int i = 1; i < nums.length; i++) {

            // Add the previous running sum to the current element
            nums[i] = nums[i] + nums[i - 1];
        }

        // Return the updated array
        return nums;
    }
}