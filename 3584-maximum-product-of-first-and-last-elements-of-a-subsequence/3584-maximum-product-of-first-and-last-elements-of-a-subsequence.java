
class Solution {
    public long maximumProduct(int[] nums, int m) {
        long ans = Long.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = m - 1; i < nums.length; i++) {
            int x = nums[i];
            int y = nums[i - m + 1];

            min = Math.min(min, y);
            max = Math.max(max, y);

            ans = Math.max(ans,
                    Math.max(1L * x * min, 1L * x * max));
        }

        return ans;
    }
}
