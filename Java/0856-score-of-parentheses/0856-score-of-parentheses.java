// https://leetcode.com/problems/score-of-parentheses

class Solution {

    public int scoreOfParentheses(String s) {

        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;

                // () contributes 2^depth based on its nesting level
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth;
                }
            }
        }

        return score;
    }
}

/*
    Approach:
    - Track the current nesting depth using depth
    - Whenever "()" is found, add its contribution based on the 
      current depth
    - A primitive "()" at depth d contributes 2^d to the total score
    - Use bit shifting to calculate 2^depth efficiently

    Time Complexity: O(n)
    Space Complexity: O(1)

    Important:
    - 1 << depth is equivalent to 2^depth for non-negative depth
    - Only an immediate "()" contributes a new score; nested groups 
    are handled by their depth
*/