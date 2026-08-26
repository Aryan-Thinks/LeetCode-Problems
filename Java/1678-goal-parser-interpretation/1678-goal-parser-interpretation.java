// https://leetcode.com/problems/goal-parser-interpretation/

class Solution {

    // Brute Force Approach

    public static String interpret(String command) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            // 'G' → append 'G'
            if (command.charAt(i) == 'G') {
                result.append('G');
            }

            // "()" → append 'o'
            if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append('o');
            }

            // "(al)" → append "al"
            if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                result.append('a');
                result.append('l');
            }
        }

        return result.toString();
    }

    // Better Implementation

    public static String interpretOptimized(String command) {

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < command.length()) {

            // 'G' → append 'G' and move to the next character.
            if (command.charAt(i) == 'G') {
                result.append('G');
                i++;
            }

            // "()" → append 'o' and skip both characters.
            else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append('o');
                i += 2;
            }

            // "(al)" → append "al" and skip all four characters.
            else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                result.append('a');
                result.append('l');
                i += 4;
            }
        }

        return result.toString();
    }
}


/*
    Brute Force Approach:
    - Traverse the command character by character.
    - If the character is 'G', append 'G' to the result.
    - If the pattern is "()", append 'o'.
    - If the pattern is "(al)", append "al".
    - Use StringBuilder to construct the final result.

    Time Complexity: O(n)
    Space Complexity: O(n)


    Better Implementation:
    - Traverse the command using a pointer.
    - Directly identify the three possible patterns:
        1. 'G'
        2. "()"
        3. "(al)"
    - Move the pointer according to the length of the matched pattern.
    - This avoids checking every character inside a matched pattern separately.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/
