class Solution {
    public int minStartValue(int[] nums) {
       int low =1;
       int high = 1000000;
       while(low<=high){
        int mid = low+(high-low)/2;

        if(isvalid(nums,mid)){
            high = mid-1;
        }else{
            low = mid+1;
        }
       }
       return low;
    }
    public boolean isvalid(int[] nums, int mid){
        int sum =mid;
        for(int num : nums){
            sum += num;
            if(sum<1){
                return false;
            }
        }
        return true;
    }
}