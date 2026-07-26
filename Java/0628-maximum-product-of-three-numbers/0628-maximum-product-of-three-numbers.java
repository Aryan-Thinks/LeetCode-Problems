// https://leetcode.com/problems/maximum-product-of-three-numbers

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        // Product of the three largest numbers
        int product1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Product of the two smallest and the largest number
        int product2 = nums[0] * nums[1] * nums[n - 1];

        // Return the larger product
        return Math.max(product1, product2);
    }
}