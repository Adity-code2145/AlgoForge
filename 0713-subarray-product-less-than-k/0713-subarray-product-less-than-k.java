class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int product = 1;
        int count = 0;
        if(k<=1){
            return 0;
        }
        for(int right = 0;right<n;right++){
            product *= arr[right];
            while(product >= k){
                product /= arr[left];
                left++;
            }
            count += right-left+1;
        }
        return count;
    }
}