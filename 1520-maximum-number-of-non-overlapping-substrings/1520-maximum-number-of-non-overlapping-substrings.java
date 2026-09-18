class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            first[idx] = Math.min(first[idx], i);
            last[idx] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Try every character
        for (int c = 0; c < 26; c++) {

            if (last[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            int i = left;

            while (i <= right) {

                int idx = s.charAt(i) - 'a';

                // Character appeared before our left boundary
                if (first[idx] < left) {
                    valid = false;
                    break;
                }

                // Expand interval
                right = Math.max(right, last[idx]);

                i++;
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by ending position
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        // Greedy selection
        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > prevEnd) {

                ans.add(s.substring(left, right + 1));

                prevEnd = right;
            }
        }

        return ans;
    }
}