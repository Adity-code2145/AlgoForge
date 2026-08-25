class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i =0;i<n;i++){
            int sum =0;
            int len = 0;
            for(int j=i;j<n;j++){
                sum +=arr[j];
                len++;
                if(len%2 ==1){
                  ans += sum;
                }
            }
            
        }
        return ans;
    }
}