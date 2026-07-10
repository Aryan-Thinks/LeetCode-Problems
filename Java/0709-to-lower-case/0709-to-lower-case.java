class Solution {
    public String toLowerCase(String s) {

        // Manual
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] = (char)(ch[i] + ('a' - 'A')); // add 32
            }
        }

        return new String(ch);

        // Using built in method
        // return s.toLowerCase();
    }
}