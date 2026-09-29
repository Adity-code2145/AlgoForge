class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int right = 0;right<n;right++){
           if(arr[right] == 0){
            count++;
           }
           while(count>k){
            if(arr[left] == 0){
                count--;
            }
            left++;
           }
           max = Math.max(max,right-left+1);
        }
        return max;
    }
}