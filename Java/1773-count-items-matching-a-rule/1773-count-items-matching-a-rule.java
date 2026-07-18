// https://leetcode.com/problems/count-items-matching-a-rule/

class Solution {
      public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count = 0;

        // Convert ruleKey into the index position of each item.
        // type  -> 0
        // color -> 1
        // name  -> 2

        int index = 0;

        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else if (ruleKey.equals("name")) {
            index = 2;
        }


        // Check every item
        for (List<String> item : items) {

            // Get the value at the required position
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

}