class Solution {
    public int[] getConcatenation(int[] nums) {

        // Original array size
        int n = nums.length;

        // Result array (twice the size)
        int[] ans = new int[n * 2];

        // Copy nums into the first and second half
        for (int i = 0; i < 2; i++) {

            // First copy
            if (i == 0) {
                for (int k = 0; k < n; k++) {
                    ans[k] = nums[k];
                }
            }

            // Second copy
            if (i == 1) {
                for (int j = 0; j < n; j++) {
                    ans[j + n] = nums[j];
                }
            }
        }

        return ans;
    }
}