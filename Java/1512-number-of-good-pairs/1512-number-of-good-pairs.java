// https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int ans = 0;

        // To traverse
        for (int i = 0; i < nums.length; i++) {
            
            // To validate condition
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}