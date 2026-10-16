
class Solution {
    static final long MOD = 1_000_000_007L;

    int n;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;

            update(1, 0, n - 1, left, i);

            last[nums[i]] = i;
            ans = (ans + sq[1]) % MOD;
        }

        return (int) ans;
    }

    void apply(int node, int l, int r, long val) {
        long len = r - l + 1L;

        sq[node] = (
            sq[node]
            + 2L * val % MOD * sum[node] % MOD
            + val * val % MOD * len % MOD
        ) % MOD;

        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) return;

        int mid = (l + r) / 2;
        long val = lazy[node];

        apply(node * 2, l, mid, val);
        apply(node * 2 + 1, mid + 1, r, val);

        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        push(node, l, r);

        int mid = (l + r) / 2;

        if (ql <= mid) {
            update(node * 2, l, mid, ql, qr);
        }

        if (qr > mid) {
            update(node * 2 + 1, mid + 1, r, ql, qr);
        }

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}