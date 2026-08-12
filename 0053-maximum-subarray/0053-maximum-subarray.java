class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int crs = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            crs = crs+nums[i];
            max = Math.max(crs,max);
            if(crs<0){
                crs = 0;
            }
        }
        return max;
    }
}