class Solution {
    public String sortSentence(String s) {
        String[] splitted = s.split(" ");
        String[] ans = new String[splitted.length];

        // Check every word
        for (int i = 0; i < splitted.length; i++) {

            // Get the last character of the word.
            int index = splitted[i].charAt(splitted[i].length() - 1) - '1';

            // Remove the number from the word
            String word = splitted[i].substring(0, splitted[i].length() - 1);

            // Put the word at its correct position
            ans[index] = word;
        }

        // Convert array into a sentence
        return String.join(" ", ans);
    }
}


/*
    Approach :
    - Split the sentence into words.
    - Get the number from the end of each word.
    - Use that number to find the correct position.
    - Remove the number from the word.
    - Store the word in the correct position.
    - Join all words and return the sentence.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/