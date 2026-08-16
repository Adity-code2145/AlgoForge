class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        // Count stones according to remainder
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // If count of remainder-0 stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If count of remainder-0 stones is odd
        return Math.abs(count[1] - count[2]) > 2;
    }
}