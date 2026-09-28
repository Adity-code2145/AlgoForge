class Solution {
    public int longestOnes(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int zc = 0;
        int max = 0;
        for(int r =0;r<n;r++){
            if(arr[r] == 0){
                zc++;
            }
            while(zc>k){
                if(arr[l] == 0){
                    zc--;
                }
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}