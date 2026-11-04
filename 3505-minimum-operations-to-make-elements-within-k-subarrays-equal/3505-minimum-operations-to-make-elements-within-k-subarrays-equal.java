
import java.util.*;

class Solution {

    class Pair {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int getMin() {
            return map.firstKey();
        }

        int getMax() {
            return map.lastKey();
        }
    }

    Pair small = new Pair();
    Pair large = new Pair();

    void balance() {

        while (small.size > large.size + 1) {
            int val = small.getMax();
            small.remove(val);
            large.add(val);
        }

        while (small.size < large.size) {
            int val = large.getMin();
            large.remove(val);
            small.add(val);
        }
    }

    void insert(int val) {
        if (small.size == 0 || val <= small.getMax()) {
            small.add(val);
        } else {
            large.add(val);
        }
        balance();
    }

    void erase(int val) {
        if (small.map.containsKey(val)) {
            small.remove(val);
        } else {
            large.remove(val);
        }
        balance();
    }

    long getCost() {
        long median = small.getMax();

        return median * small.size - small.sum
             + large.sum - median * large.size;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        long[] cost = new long[n - x + 1];

        for (int i = 0; i < n; i++) {

            insert(nums[i]);

            if (i >= x) {
                erase(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int j = 0; j <= k; j++) {

            for (int i = 0; i <= n; i++) {

                if (dp[j][i] == INF) continue;
                if (i < n) {
                    dp[j][i + 1] =
                        Math.min(dp[j][i + 1], dp[j][i]);
                }
                if (j < k && i + x <= n) {
                    dp[j + 1][i + x] =
                        Math.min(
                            dp[j + 1][i + x],
                            dp[j][i] + cost[i]
                        );
                }
            }
        }

        return dp[k][n];
    }
}
