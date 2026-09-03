class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd = Integer.MAX_VALUE;
        for(int x : nums1){
            if(x%2 != 0){
                odd = Math.min(odd,x);
            }
        }
        for(int x : nums1){
            if(x%2 ==0 && odd != Integer.MAX_VALUE){
                if(x<odd){
                    return false;
                }
            }
        }
        return true;
    }
}