class Solution {
    public int[] searchRange(int[] nums, int k) {
        int n = nums.length;
        int first = findfirst(nums,k);
        int last = findlast(nums,k);
        return new int[]{first,last};
    }
    public int findfirst(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int idx = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                idx = mid;
                high = mid-1;
            }
        }
        return idx;
    }
    public int findlast(int[] nums, int k){
        int n = nums.length;
        int l= 0;
        int h =n-1;
        int idx =-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]<k){
                l = mid+1;
            }
            else if(nums[mid]>k){
                h = mid-1;
            }
            else{
                idx = mid;
                l = mid+1;
            }
        }
        return idx;
    }
}