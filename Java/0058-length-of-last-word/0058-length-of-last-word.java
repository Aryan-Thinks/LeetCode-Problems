class Solution {
    public int lengthOfLastWord(String s) {
        String[] strArr = s.trim().split("\\s+");
        int end = strArr.length - 1;

        int lastWordLength = strArr[end].length();

        return lastWordLength;
    }
}