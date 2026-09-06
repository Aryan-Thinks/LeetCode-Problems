// https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

class Solution {
    
    public int numOfStrings(String[] patterns, String word) {

        int count = 0;

        for (int i = 0; i < patterns.length; i++) {

            // contains() checks whether the pattern is a substring of word.
            if (word.contains(patterns[i])) {
                count++;
            }
        }

        return count;
    }
}

/*
    Approach:
    - Traverse every pattern.
    - Check if it exists as a substring of word using contains().
    - Increment count when found.

    Time Complexity: O(n * m * k) in the worst case
        n -> number of patterns
        m -> length of word
        k -> length of pattern

    Space Complexity: O(1) auxiliary space.

    Important:
    - Each pattern is counted only once.
    - String.contains() returns true/false.
*/