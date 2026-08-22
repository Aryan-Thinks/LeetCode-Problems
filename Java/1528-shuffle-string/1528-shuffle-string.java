class Solution {

    public static String restoreString(String s, int[] indices) {

        char[] ans = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ans[indices[i]] = s.charAt(i);
        }

        return new String(ans);
    }

}

/* Approach :
     - String is immutable, so we cannot modify it directly.
     - Create a char[] of the same length.
     - indices[i] tells where s.charAt(i) should be placed.
     - Convert the char[] back to a String. 
        Time Complexity: O(n)
        Space Complexity: O(n)
*/