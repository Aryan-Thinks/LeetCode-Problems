// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

class Solution {

    // Brute Force Approach
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder fullWord1 = new StringBuilder();
        StringBuilder fullWord2 = new StringBuilder();

        for (String word : word1) {
            fullWord1.append(word);
        }

        for (String word : word2) {
            fullWord2.append(word);
        }

        return fullWord1.toString().equals(fullWord2.toString());
    }


    // Optimized Approach
    public static boolean arrayStringsAreEqualOptimized(String[] word1, String[] word2) {

        // i, j → current string
        // p, q → current character inside that string
        int i = 0;
        int j = 0;
        int p = 0;
        int q = 0;

        while (i < word1.length && j < word2.length) {

            // Compare characters directly without creating concatenated strings.
            if (word1[i].charAt(p) != word2[j].charAt(q)) {
                return false;
            }

            p++;
            q++;

            // Current word in word1 is finished → move to the next word.
            if (p == word1[i].length()) {
                i++;
                p = 0;
            }

            // Current word in word2 is finished → move to the next word.
            if (q == word2[j].length()) {
                j++;
                q = 0;
            }
        }

        // Both arrays must be completely processed.
        return i == word1.length && j == word2.length;
    }

}

/*
    Brute Force Approach:
    - Concatenate all strings from both arrays.
    - Compare the two resulting strings.

    Time Complexity: O(n)
    Space Complexity: O(n)


    Optimized Approach:
    - Compare characters directly without creating the complete strings.
    - Use pointers to track the current string and character in each array.
    - Move to the next string when the current string is completely processed.
    - Return false as soon as a mismatch is found.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/
