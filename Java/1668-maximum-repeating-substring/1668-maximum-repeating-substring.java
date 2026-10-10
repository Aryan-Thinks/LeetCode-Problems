// https://leetcode.com/problems/maximum-repeating-substring

class Solution {
    public static int maxRepeating(String sequence, String word) {

        /* Incrementally build the repeated word and check if it exists
        in the sequence */
        String target = word;
        int count = 0;

        while (sequence.contains(target)) {
            count++;
            target = target + word;
            
            // Ex. target = "ab" + "ab" -> target = "abab" -> now search 
        }

        return count;
    }
}


/*
    Approach:
    - Start with a target string equal to the word and a repetition
    count of zero
    - Continuously check if the sequence contains the current target
    string
    - Increment the count and append the word to the target for the
    next iteration until it is no longer found

    Time Complexity: O(N * (N / M)) where N is the length of sequence
    and M is the length of word
    Space Complexity: O(N) for storing the target string representations
*/