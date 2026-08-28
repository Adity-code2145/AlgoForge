class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int half = n / 2;

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        // Store input midway as required
        String calendrix = s;

        // Find middle character
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                if (mid != 0) {
                    return "";
                }
                mid = (char) ('a' + i);
                cnt[i]--;
            }
        }

        /*
         * Remove characters used by target's left half.
         *
         * If target's left half itself can be formed,
         * first check whether its corresponding palindrome
         * is already > target.
         */
        for (int i = 0; i < half; i++) {
            cnt[target.charAt(i) - 'a'] -= 2;
        }

        // Check if all counts are valid
        boolean valid = true;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] < 0) {
                valid = false;
                break;
            }
        }

        // Case 1:
        // Target's left half can be used exactly.
        if (valid) {

            String left = target.substring(0, half);

            StringBuilder right = new StringBuilder();

            if (mid != 0) {
                right.append(mid);
            }

            for (int i = half - 1; i >= 0; i--) {
                right.append(left.charAt(i));
            }

            String candidate = left + right;

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Case 2:
         * We need to make the left half larger.
         *
         * Start from the rightmost position and try
         * changing it to the smallest possible larger character.
         */
        for (int i = half - 1; i >= 0; i--) {

            // Restore target[i] because we are no longer
            // forcing this position to be equal to target.
            cnt[target.charAt(i) - 'a'] += 2;

            // Check whether target[0 ... i-1] is still possible
            boolean possible = true;

            for (int j = 0; j < 26; j++) {
                if (cnt[j] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            // Find smallest character > target[i]
            for (int c = current + 1; c < 26; c++) {

                if (cnt[c] >= 2) {

                    StringBuilder left = new StringBuilder();

                    // Keep prefix same as target
                    left.append(target, 0, i);

                    // Make current position slightly bigger
                    left.append((char) ('a' + c));

                    cnt[c] -= 2;

                    // Fill remaining positions with smallest chars
                    for (int x = 0; x < 26; x++) {
                        while (cnt[x] >= 2) {
                            left.append((char) ('a' + x));
                            cnt[x] -= 2;
                        }
                    }

                    // Build palindrome
                    StringBuilder ans = new StringBuilder();

                    ans.append(left);

                    if (mid != 0) {
                        ans.append(mid);
                    }

                    for (int k = left.length() - 1; k >= 0; k--) {
                        ans.append(left.charAt(k));
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}