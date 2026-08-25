class Solution {
    // Brute Force Approach
    public static boolean halvesAreAlike(String s) {

        int mid = s.length() / 2;

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < mid; i++) {

            if (isVowel(s.charAt(i))) {
                count1++;
            }
        }

        for (int i = mid; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {
                count2++;
            }
        }

        return count1 == count2;
    }


    private static boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }


    // Optimized Approach
    public static boolean halvesAreAlikeOptimized(String s) {

        int mid = s.length() / 2;
        int count = 0;

        for (int i = 0; i < mid; i++) {

            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        // Subtract vowels from the second half instead of using a second counter.
        for (int i = mid; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {
                count--;
            }
        }

        return count == 0;
    }
}

/*
    Brute Force Approach:
    - Find the middle of the string.
    - Count vowels in the first half.
    - Count vowels in the second half.
    - Compare both counts.

    Time Complexity: O(n)
    Space Complexity: O(1)


    Optimized Approach:
    - Use one variable instead of two counters.
    - Add for vowels in the first half.
    - Subtract for vowels in the second half.
    - If the final count is 0, both halves have the same number of vowels.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/
