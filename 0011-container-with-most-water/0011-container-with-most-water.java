class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        int max = Integer.MIN_VALUE;
        while(left<right){
            int h = Math.min(height[left],height[right]);
            int w = right-left;
            int area = h*w;
            max = Math.max(area,max);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}