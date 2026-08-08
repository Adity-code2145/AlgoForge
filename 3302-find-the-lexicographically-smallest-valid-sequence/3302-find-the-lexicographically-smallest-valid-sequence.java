class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // latest[j] = latest possible index in word1
        // from which word2[j...] can be matched
        int[] latest = new int[m];

        int pos = n;

        for (int j = m - 1; j >= 0; j--) {
            pos = word1.lastIndexOf(word2.charAt(j), pos - 1);

            if (pos == -1) {
                latest[j] = -1;
            } else {
                latest[j] = pos;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        int j = 0;
        boolean mismatchUsed = false;

        while (i < n && j < m) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                i++;
                j++;
            }

            // Use the one allowed mismatch
            else if (!mismatchUsed &&
                    (j == m - 1 || latest[j + 1] > i)) {

                ans[j] = i;
                i++;
                j++;
                mismatchUsed = true;
            }

            // Skip current character
            else {
                i++;
            }
        }

        // Could not form a valid sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}