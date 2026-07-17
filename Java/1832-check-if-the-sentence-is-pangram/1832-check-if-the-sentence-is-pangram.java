// https://leetcode.com/problems/check-if-the-sentence-is-pangram/

class Solution {
    public boolean checkIfPangram(String sentence) {

        // Array to keep track of whether each letter (a-z) is present
        boolean[] letters = new boolean[26];

        // Traverse each character in the sentence
        for (int i = 0; i < sentence.length(); i++) {

            // Convert character to an index (a -> 0, b -> 1, ..., z -> 25)
            int index = sentence.charAt(i) - 'a';

            // Mark the letter as found
            letters[index] = true;
        }

        // Check if every letter has been found
        for (int i = 0; i < 26; i++) {

            // If any letter is missing, it's not a pangram
            if (!letters[i]) {
                return false;
            }
        }

        // All 26 letters are present
        return true;
    }
}