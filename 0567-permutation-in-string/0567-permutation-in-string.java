class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        HashMap<Character, Integer> s1map = new HashMap<>();
        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            s1map.put(ch, s1map.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> s2map = new HashMap<>();
        int left = 0;
        for(int right =0;right<s2.length();right++){
            char ch = s2.charAt(right);
            s2map.put(ch,s2map.getOrDefault(ch,0)+1);

            if(right-left+1>s1.length()){
                char comp = s2.charAt(left);
                s2map.put(comp, s2map.get(comp)-1);
                if(s2map.get(comp)==0){
                    s2map.remove(comp);
                }
                left++;
            }
            if(s1map.equals(s2map)){
                return true;
            }
        }
        return false;
    }
}