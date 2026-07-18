class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {

        // ArrayList automatically shifts elements to the right
        // when inserting at a specific index.
        ArrayList<Integer> target = new ArrayList<>();

        // Insert each number at its given position.
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }

        // ArrayList<Integer> cannot be directly converted to int[],
        // so copy each element manually.
        int[] ans = new int[target.size()];
        for (int i = 0; i < target.size(); i++) {
            ans[i] = target.get(i);
        }

        return ans;
    }
}