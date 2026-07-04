class Solution {
    public int[] buildArray(int[] nums) {

        // Store the rearranged values
        int[] ans = new int[nums.length];

        // ans[i] = nums[nums[i]]
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}