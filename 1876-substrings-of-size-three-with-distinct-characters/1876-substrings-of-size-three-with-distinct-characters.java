class Solution {
    public int countGoodSubstrings(String s) {
        int l =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(r-l+1>3){
                char comp = s.charAt(l);
                map.put(comp,map.get(comp)-1);
                if(map.get(comp)==0){
                    map.remove(comp);
                }
                l++;
            }
            if(r-l+1 == 3 && map.size() == 3){
                count++;
            }
        }
        return count;
    }
}