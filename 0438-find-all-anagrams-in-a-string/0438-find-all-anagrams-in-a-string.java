class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int idx = -1;
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();
        for(int i =0;i<p.length();i++){
            char ch = p.charAt(i);
            pmap.put(ch,pmap.getOrDefault(ch,0)+1);
        }
        int left = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch,0)+1);
            while(right-left+1>p.length()){
                char comp = s.charAt(left);
                smap.put(comp,smap.get(comp)-1);
                if(smap.get(comp)==0){
                    smap.remove(comp);
                }
                left++;
            }
            if(smap.equals(pmap)){
                idx = left;
                ans.add(idx);
            }
        }
        return ans;
    }
}