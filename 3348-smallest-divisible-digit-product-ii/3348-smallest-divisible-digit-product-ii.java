class Solution {
    // DIGIT_PRIMES[d][p] = exponent of prime p in digit d (p in {2,3,5,7})
    private static final int[][] DIGIT_PRIMES = new int[10][8];
    static {
        DIGIT_PRIMES[2][2] = 1;
        DIGIT_PRIMES[3][3] = 1;
        DIGIT_PRIMES[4][2] = 2;
        DIGIT_PRIMES[5][5] = 1;
        DIGIT_PRIMES[6][2] = 1; DIGIT_PRIMES[6][3] = 1;
        DIGIT_PRIMES[7][7] = 1;
        DIGIT_PRIMES[8][2] = 3;
        DIGIT_PRIMES[9][3] = 2;
    }

    public String smallestNumber(String num, long t) {
        boolean[] ok = new boolean[1];
        int[] primeCount = getPrimeCount(t, ok);
        if (!ok[0]) return "-1";                 // t has a prime factor other than 2,3,5,7

        int[] factorCount = getFactorCount(primeCount);
        if (sumValues(factorCount) > num.length()) {
            // Even the minimal representation needs more digits than num has,
            // so the answer must be longer -> smallest number of that minimal length.
            return construct(factorCount);
        }

        int[] prefix = getPrimeCountFromString(num);
        int firstZeroIndex = num.indexOf('0');
        if (firstZeroIndex == -1) {
            firstZeroIndex = num.length();
            if (isSubset(primeCount, prefix)) {
                return num;                       // num itself already works
            }
        }

        // Try to keep num as a prefix as long as possible; bump the rightmost
        // feasible digit up, then fill the remaining suffix optimally.
        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            prefix = subtract(prefix, DIGIT_PRIMES[d]);   // prefix now covers [0, i)
            int spaceAfter = num.length() - 1 - i;
            if (i > firstZeroIndex) continue;
            for (int bigger = d + 1; bigger < 10; bigger++) {
                int[] needed = subtract(subtract(primeCount, prefix), DIGIT_PRIMES[bigger]);
                int[] factorsAfter = getFactorCount(needed);
                int s = sumValues(factorsAfter);
                if (s <= spaceAfter) {
                    int fillOnes = spaceAfter - s;
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + bigger));
                    for (int k = 0; k < fillOnes; k++) sb.append('1');
                    sb.append(construct(factorsAfter));
                    return sb.toString();
                }
            }
        }

        // No same-length answer -> go one digit longer.
        int[] factorsExt = getFactorCount(primeCount);
        int leadOnes = num.length() + 1 - sumValues(factorsExt);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < leadOnes; k++) sb.append('1');
        sb.append(construct(factorsExt));
        return sb.toString();
    }

    private int[] getPrimeCount(long t, boolean[] okOut) {
        int[] count = new int[8];
        long x = t;
        for (int p : new int[]{2, 3, 5, 7}) {
            while (x % p == 0) {
                x /= p;
                count[p]++;
            }
        }
        okOut[0] = (x == 1);
        return count;
    }

    private int[] getPrimeCountFromString(String num) {
        int[] count = new int[8];
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            for (int p : new int[]{2, 3, 5, 7}) {
                count[p] += DIGIT_PRIMES[d][p];
            }
        }
        return count;
    }

    // Minimal digit multiset (fewest digits, then smallest arrangement)
    // that supplies the given prime powers. Result indexed 2..9.
    private int[] getFactorCount(int[] count) {
        int c2 = count[2], c3 = count[3], c5 = count[5], c7 = count[7];
        int count8 = c2 / 3, remaining2 = c2 % 3;
        int count9 = c3 / 2, count3 = c3 % 2;
        int count4 = remaining2 / 2, count2 = remaining2 % 2;
        int count6 = 0;
        if (count2 == 1 && count3 == 1) {          // combine leftover 2*3 -> 6
            count2 = 0; count3 = 0; count6 = 1;
        }
        if (count3 == 1 && count4 == 1) {          // 3*4 -> 2*6 (same digit count, smaller value)
            count2 = 1; count6 = 1; count3 = 0; count4 = 0;
        }
        int[] res = new int[10];
        res[2] = count2; res[3] = count3; res[4] = count4; res[5] = c5;
        res[6] = count6; res[7] = c7; res[8] = count8; res[9] = count9;
        return res;
    }

    private String construct(int[] factors) {
        StringBuilder sb = new StringBuilder();
        for (int d = 2; d < 10; d++) {
            for (int k = 0; k < factors[d]; k++) sb.append((char) ('0' + d));
        }
        return sb.toString();
    }

    private int sumValues(int[] arr) {
        int s = 0;
        for (int v : arr) s += v;
        return s;
    }

    private boolean isSubset(int[] a, int[] b) {
        for (int p : new int[]{2, 3, 5, 7}) {
            if (b[p] < a[p]) return false;
        }
        return true;
    }

    private int[] subtract(int[] a, int[] b) {
        int[] res = a.clone();
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(0, res[i] - b[i]);
        }
        return res;
    }
}