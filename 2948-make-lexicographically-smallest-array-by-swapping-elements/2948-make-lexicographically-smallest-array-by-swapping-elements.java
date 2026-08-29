import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Store indices
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // Sort indices according to nums values
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] ans = new int[n];

        int i = 0;

        while (i < n) {

            int j = i + 1;

            // Find one connected group
            while (j < n &&
                   nums[idx[j]] - nums[idx[j - 1]] <= limit) {
                j++;
            }

            // Get original indices of this group
            Integer[] group = Arrays.copyOfRange(idx, i, j);

            // Sort indices
            Arrays.sort(group);

            // Smallest values -> smallest original indices
            for (int k = i; k < j; k++) {
                ans[group[k - i]] = nums[idx[k]];
            }

            i = j;
        }

        return ans;
    }
}