class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int max = 0;
        for(int right = 0;right<n;right++){
            if(nums[right] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;

            }
        }
        return max;
    }
}