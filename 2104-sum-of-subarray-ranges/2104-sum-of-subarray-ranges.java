class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        long ans = 0;
        for(int i =0;i<n;i++){
            long min = arr[i];
            long max = arr[i];
            for(int j =i;j<n;j++){
                 min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                ans += max-min;
            }
        }
        return ans;
    }
}