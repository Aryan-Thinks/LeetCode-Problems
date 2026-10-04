// https://leetcode.com/problems/valid-parenthesis-string

class Solution {
    public static boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        // Track the minimum and maximum possible number of open brackets.
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else {
                // '*' can be ')', '(' or empty
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {
                return false;
            }

            minOpen = Math.max(minOpen, 0);
        }

        return minOpen == 0;
    }
}

/*
    Approach:
    
    - Track the minimum and maximum possible number of unmatched '(' brackets
    - '(' increases both ranges, while ')' decreases both
    - '*' can act as '(', ')' or empty, so it expands the possible range
    - If maxOpen becomes negative, the string cannot be valid

    Time Complexity: O(n)
    Space Complexity: O(1)

    Important:
    - minOpen cannot be negative because '*' can be treated as empty
    - The string is valid only when 0 is within the possible open-bracket range
*/