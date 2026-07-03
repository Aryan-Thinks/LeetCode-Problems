class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Store the current maximum candies
        int maxElm = 0;
        List<Boolean> result = new ArrayList<>();

        // Find the maximum value in the array
        for (int i = 0; i < candies.length; i++) {
            if (maxElm < candies[i]) {
                maxElm = candies[i];
            }
        }

        // If current candies + extra candies >= maximum,
        // this kid can have the greatest number of candies
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxElm) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}