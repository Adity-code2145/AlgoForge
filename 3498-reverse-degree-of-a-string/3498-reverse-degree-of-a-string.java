class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i =0;i<s.length();i++){
            int ch = s.charAt(i);

            int reverse = 'z'- ch+1;
            ans += reverse * (i+1);
        }
        return ans;
    }
}