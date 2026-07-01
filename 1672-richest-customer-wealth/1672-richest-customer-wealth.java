class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        // Check each customer's total wealth
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;

            // Add money from all bank accounts
            for (int j = 0; j < accounts[i].length; j++) {
                sum = sum + accounts[i][j];
            }

            // Update maximum wealth found so far
            maxWealth = Math.max(sum, maxWealth);
        }

        return maxWealth;
    }
}