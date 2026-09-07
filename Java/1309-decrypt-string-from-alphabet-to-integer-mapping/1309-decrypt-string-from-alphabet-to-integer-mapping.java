// https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

class Solution {
    public String freqAlphabets(String s) {

        StringBuilder res = new StringBuilder();

        // Two digits followed by # represent numbers from 10 to 26
        for (int i = 0; i < s.length();) {

            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {

                int first = s.charAt(i) - '0';
                int second = s.charAt(i + 1) - '0';

                int num = first * 10 + second;

                res.append((char) ('a' + num - 1));

                i = i + 3;

            } else {

                int num = s.charAt(i) - '0';

                res.append((char) ('a' + num - 1));

                i = i + 1;
            }
        }

        return res.toString();
    }
}


/*
    Approach:
    - Traverse the string from left to right.
    - If two digits are followed by '#', convert them into a number from 10 to 26.
    - Otherwise, convert the current digit from 1 to 9.
    - Map each number to its corresponding character using 'a' + num - 1.

    Time Complexity: O(n)
    Space Complexity: O(n)

    Important:
    - Subtract '0' to convert a digit character into an integer.
    - Use StringBuilder.append() to build the result.
*/
