class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            while(map.containsKey(ch)){
                char comp = s.charAt(left);
                map.put(comp,map.get(comp)-1);
                if(map.get(comp)==0){
                    map.remove(comp);
                }
                left++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}