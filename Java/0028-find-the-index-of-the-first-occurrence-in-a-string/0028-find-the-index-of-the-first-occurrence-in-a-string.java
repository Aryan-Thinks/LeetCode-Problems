// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {

    // Brute Force
    public static int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }


    // Optimized Approach
    public static int strStrOptimized(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;

            while (j < needle.length()
                    && haystack.charAt(i + j) == needle.charAt(j)) {

                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}


/*
    Brute Force Approach:
    - Start from every possible index in haystack.
    - Take a substring of the same length as needle.
    - Compare the substring with needle.
    - If they are equal, return the current index.
    - If no match is found, return -1.

    Time Complexity: O(n * m)
    Space Complexity: O(m)


    Optimized Approach:
    - Start from every possible index in haystack.
    - Compare characters of haystack and needle one by one.
    - If all characters match, return the current index.
    - Avoid creating a new substring.
    - If no match is found, return -1.

    Time Complexity: O(n * m)
    Space Complexity: O(1)

    Where:
    n = length of haystack
    m = length of needle
*/