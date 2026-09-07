// https://leetcode.com/problems/long-pressed-name/

class Solution {
    
    public static boolean isLongPressedName(String name, String typed) {

        // Two pointer approach

        int i = 0;
        int j = 0;

        while (j < typed.length()) {

            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                // Normal character
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Long pressed character
                j++;
            } else {
                return false;
            }
        }

        return i == name.length();
    }
}



/*
    Approach:
    - Use two pointers to traverse name and typed
    - If characters match, move both pointers
    - If the current typed character matches the previous one, it is a long pressed character
    - Finally, check whether all characters in name are matched

    Time Complexity: O(n + m)
    Space Complexity: O(1)

    Important:
    - Character order matters in this problem
    - Extra characters are valid only when they are long pressed characters
*/
