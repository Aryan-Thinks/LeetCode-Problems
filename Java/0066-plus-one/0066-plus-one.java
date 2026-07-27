// https://leetcode.com/problems/plus-one/

class Solution {
    public int[] plusOne(int[] digits) {

        // Traverse from the last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            // If no carry is generated, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // 9 + 1 = 10 -> store 0 and carry 1
            digits[i] = 0;
        }

        // All digits were 9 (e.g. 999 -> 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}