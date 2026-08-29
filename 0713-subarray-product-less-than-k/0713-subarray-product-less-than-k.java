class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left =0;
        int product = 1;
        if(k<=1){
            return 0;
        }
        int count = 0;
        for(int right = left ;right<n;right++){
            product *= nums[right];
           while(product>=k){
            product /= nums[left];
            left++;
           }
           count += right-left+1;
        }
        return count;
    }
}