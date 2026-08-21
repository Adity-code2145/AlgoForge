class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) k * getMin(coins);

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Returns how many distinct amounts <= x
    // can be formed.
    private long count(long x, int[] coins) {

        int n = coins.length;
        long ans = 0;

        // Generate all subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = getLCM(lcm, coins[i]);

                    // No multiple of this LCM can be <= x
                    if (lcm > x) {
                        break;
                    }
                }
            }

            if (bits % 2 == 1) {
                ans += x / lcm;
            } else {
                ans -= x / lcm;
            }
        }

        return ans;
    }

    private long getLCM(long a, long b) {
        return (a / getGCD(a, b)) * b;
    }

    private long getGCD(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private int getMin(int[] coins) {

        int min = coins[0];

        for (int coin : coins) {
            min = Math.min(min, coin);
        }

        return min;
    }
}