class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int max = -1;
        for(int i = 0;i<n;i++){
            if(nums[i]!=i){
                max &= nums[i];
            }
        }
        return Math.max(max,0);
    }
}