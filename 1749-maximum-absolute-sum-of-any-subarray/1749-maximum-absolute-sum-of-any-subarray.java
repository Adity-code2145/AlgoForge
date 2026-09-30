class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int currmax = 0;
        int currmin = 0;
        int maxsum = 0;
        int minsum = 0;
        for(int num : nums){
            currmax = Math.max(num,currmax+num);
            maxsum = Math.max(maxsum, currmax);

            currmin = Math.min(num, currmin+num);
            minsum = Math.min(minsum,currmin);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}