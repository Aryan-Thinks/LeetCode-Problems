// https://leetcode.com/problems/valid-palindrome/

class Solution {
    public static boolean isPalindrome(String s) {

        s = s.trim().toLowerCase();

        char[] arr = s.toCharArray();
        StringBuilder mod = new StringBuilder();

        // Keep only alphanumeric characters before checking the palindrome
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetterOrDigit(arr[i])) {
                mod.append(arr[i]);
            }
        }

        // Check palindrome
        int start = 0;
        int end = mod.length() - 1;

        while (start < end) {
            if (mod.charAt(start) != mod.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindromeOptimized(String s) {

        int start = 0;
        int end = s.length() - 1;

        // Compare valid characters directly without creating a new string
        while (start < end) {

            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start))
                    != Character.toLowerCase(s.charAt(end))) {
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
    - Original: Create a cleaned string containing only alphanumeric
     characters, then use two pointers
    - Optimized: Use two pointers directly on the original string and
     skip non-alphanumeric characters
    - The optimized approach avoids creating an additional StringBuilder
     or character array

    Time Complexity:
    - Original: O(n)
    - Optimized: O(n)

    Space Complexity:
    - Original: O(n)
    - Optimized: O(1)

    Important:
    - Character.isLetterOrDigit() is used because the problem considers
     both letters and digits
    - Character.toLowerCase() allows case-insensitive comparison
*/
