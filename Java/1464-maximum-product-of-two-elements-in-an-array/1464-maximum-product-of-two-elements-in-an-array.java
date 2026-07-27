// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

class Solution {
    public int maxProduct(int[] nums) {

        int maxElm = Integer.MIN_VALUE;
        int secondMaxElm = Integer.MIN_VALUE;

        // Find the largest and second largest elements
        for (int num : nums) {

            if (num > maxElm) {
                secondMaxElm = maxElm;
                maxElm = num;
            } else if (num > secondMaxElm) {
                secondMaxElm = num;
            }
        }

        return (maxElm - 1) * (secondMaxElm - 1);
    }
}