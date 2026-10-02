class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tmap.put(ch,tmap.getOrDefault(ch,0)+1);
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int count = t.length();
        int left = 0;
        String ans = "";

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            smap.put(ch,smap.getOrDefault(ch,0)+1);
            if(tmap.containsKey(ch) && smap.get(ch) <= tmap.get(ch)){
                count--;
            }

            while(count == 0){
                if(right-left+1 < min){
                    min = right-left+1;
                    ans = s.substring(left,right+1);
                }

                char leftchar = s.charAt(left);
                smap.put(leftchar,smap.get(leftchar)-1);

                if(tmap.containsKey(leftchar) && smap.get(leftchar)< tmap.get(leftchar)){
                    count++;
                }
                left++;
            }
        }
        return ans;
    }
}