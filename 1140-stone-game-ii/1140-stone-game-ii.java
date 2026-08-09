class Solution {
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {
        int n = piles.length;

        // All remaining piles can be taken
        if (i >= n) {
            return 0;
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        // If we can take all remaining piles
        if (i + 2 * M >= n) {
            return dp[i][M] = suffix[i];
        }

        int maxStones = 0;

        // Take X piles, where 1 <= X <= 2*M
        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int opponent = solve(i + X, Math.max(M, X), piles);

            // Current player gets all remaining stones
            // minus what opponent can optimally get
            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][M] = maxStones;
    }
}