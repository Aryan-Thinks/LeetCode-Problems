// https://leetcode.com/problems/add-to-array-form-of-integer/

class Solution {
    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> result = new ArrayList<>();
        int currentIndex = num.length - 1;

        // Start adding from the last digit
        while (currentIndex >= 0 || k > 0) {

            if (currentIndex >= 0) {
                k = k + num[currentIndex];
                currentIndex--;
            }

            result.add(k % 10); // Current digit
            k = k / 10;        // Carry for next iteration
        }

        // Digits were added in reverse order
        Collections.reverse(result);

        return result;
    }
}

/*
Approach:
    1. Start traversing the array from the last digit.
    2. Add the current digit of the array to k.
    3. Store the last digit of k using k % 10 in the result.
    4. Remove the last digit from k using k / 10. The remaining value acts as the carry.
    5. Continue until all array digits are processed and k becomes 0.
    6. Since digits are added from right to left, reverse the result at the end.
*/