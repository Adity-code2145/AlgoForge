class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0;right<n;right++){
            sum += arr[right];
            while(sum>=target){
                min = Math.min(min,right-left+1);
                sum -= arr[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }
}