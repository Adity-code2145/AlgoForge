class Solution {
    public int maximumLengthSubstring(String s) {

        int[] count = new int[26];

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            int index = ch - 'a';

            count[index]++;

            while (count[index] > 2) {

                char leftChar = s.charAt(left);
                int leftIndex = leftChar - 'a';

                count[leftIndex]--;
                left++;
            }

            int length = right - left + 1;
            max = Math.max(max, length);
        }

        return max;
    }
}