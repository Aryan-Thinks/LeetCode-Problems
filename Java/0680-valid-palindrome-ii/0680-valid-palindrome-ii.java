// https://leetcode.com/problems/valid-palindrome-ii/

class Solution {

    public static boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        // At the first mismatch, try deleting either character
        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end)
                        || isPalindrome(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean validPalindromeOptimized(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {

                // Only one deletion is allowed, so check both choices
                return checkPalindrome(s, start + 1, end)
                        || checkPalindrome(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private static boolean checkPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}


/*
    Approach:
    - Use two pointers from both ends and compare characters
    - At the first mismatch, one character can be deleted
    - Check both possibilities: skip the left character or skip
    the right character
    - The remaining substring must be a palindrome

    Time Complexity:
    - Original: O(n)
    - Optimized: O(n)

    Space Complexity:
    - Original: O(1)
    - Optimized: O(1)

    Important:
    - Only the first mismatch needs special handling because at most
    one deletion is allowed
    - Both deletion choices must be checked; always deleting the same
    side can give incorrect results
*/