class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int ans = 0;
        for(int i = 1;i<n;i++){
            min = Math.min(min,nums[i]);
        }
        for(int i = 0;i<n;i++){
            ans += nums[i] - min;
        }
        return ans;
    }
}