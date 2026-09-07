// https://leetcode.com/problems/reverse-words-in-a-string-iii/

class Solution {
    // Reverse whole sentence
    public static String reverseWords(String s) {

        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            // Reverse each word independently while preserving word order
            words[i] = reverseWord(words[i]);
        }

        return String.join(" ", words);
    }

    // Reverse single word
    public static String reverseWord(String s) {

        StringBuilder reversedWord = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            reversedWord.append(s.charAt(i));
        }

        return reversedWord.toString();
    }
}

/*
    Approach:
    - Split the string into individual words
    - Reverse each word using StringBuilder
    - Join the reversed words back with spaces
    - Word order remains unchanged

    Time Complexity: O(n)
    Space Complexity: O(n)

    Important:
    - StringBuilder is used for efficient character appending
    - The total number of characters processed is n
*/