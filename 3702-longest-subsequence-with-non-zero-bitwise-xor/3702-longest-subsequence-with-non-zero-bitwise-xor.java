class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // If XOR of complete array is non-zero
        if (xor != 0) {
            return n;
        }

        // If all elements are 0
        for (int num : nums) {
            if (num != 0) {
                return n - 1;
            }
        }

        return 0;
    }
}