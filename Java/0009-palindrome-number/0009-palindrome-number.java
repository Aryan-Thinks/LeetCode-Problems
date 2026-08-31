// https://leetcode.com/problems/palindrome-number

class Solution {

    // Optimized Approach - Reverse Half of the Number
    public boolean isPalindrome(int x) {

        // Edge cases
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;

        // Reverse only half of the number
        while (x > reversed) {

            int lastDigit = x % 10;

            reversed = reversed * 10 + lastDigit;

            x /= 10; // Remove last digit from x
        }

        // Even digits: x == reversed
        // Odd digits: x == reversed / 10
        return x == reversed || x == reversed / 10;
    }


    // Brute Force - Using String
    public boolean isPalindrome2(int x) {

        // Edge case
        if (x < 0) {
            return false;
        }

        // Convert number to String
        String strNum = Integer.toString(x);

        int start = 0;
        int end = strNum.length() - 1;

        // Compare characters from both ends
        while (start < end) {

            if (strNum.charAt(start) != strNum.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}


/*
    Brute Force Approach - String:

    - Convert the integer into a String.
    - Use two pointers: start and end.
    - Compare characters from both ends.
    - Move start forward and end backward.
    - If any characters do not match, return false.
    - If all characters match, return true.

    Time Complexity: O(log10(x))
    Space Complexity: O(log10(x))


    Optimized Approach - Reverse Half:

    - Negative numbers cannot be palindromes.
    - Numbers ending with 0 cannot be palindromes
      unless the number itself is 0.
    - Reverse only the second half of the number.
    - Stop when the reversed half becomes greater than
      or equal to the remaining first half.
    - For an even number of digits:
          x == reversed
    - For an odd number of digits:
          x == reversed / 10

    Time Complexity: O(log10(x))
    Space Complexity: O(1)


    Where:
    log10(x) = number of digits in x
*/
