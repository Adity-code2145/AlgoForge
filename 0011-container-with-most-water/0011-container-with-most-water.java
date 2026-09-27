class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int max = Integer.MIN_VALUE;
        while(l<r){
            int height = Math.min(arr[l],arr[r]);
            int w = r-l;
            int area = height*w;
            max = Math.max(max,area);
            if(arr[l]>arr[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}