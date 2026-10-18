
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Precompute combinations nCr
        comb = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (int) (((long) comb[i - 1][j - 1]
                    + comb[i - 1][j]) % MOD);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> nums) {
        int n = nums.size();

        if (n <= 2) {
            return 1;
        }

        int root = nums.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int val = nums.get(i);

            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        long waysLeft = solve(left);
        long waysRight = solve(right);

        long waysToMerge = comb[n - 1][left.size()];

        return (((waysToMerge * waysLeft) % MOD)
                * waysRight) % MOD;
    }
}
