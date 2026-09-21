class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int mod = num % k;

            // Subarrays ending at current index
            long[] newDp = new long[k];

            // Start a new subarray with only num
            newDp[mod] = 1;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                int newRem = (int)((1L * r * mod) % k);

                newDp[newRem] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            dp = newDp;
        }

        return ans;
    }
}