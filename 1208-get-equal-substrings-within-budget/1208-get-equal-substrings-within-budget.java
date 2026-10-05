class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int cost = 0;
        int max = 0;
        for(int r = 0;r<s.length();r++){
            cost += Math.abs(s.charAt(r)-t.charAt(r));
            while(cost>maxCost){
                cost -= Math.abs(s.charAt(l)-t.charAt(l));
                l++;
                
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}