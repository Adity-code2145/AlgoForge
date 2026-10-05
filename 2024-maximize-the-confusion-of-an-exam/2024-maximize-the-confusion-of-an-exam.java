class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = -1;
        for(int right =0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int maxFreq = 0;

            for (int freq : map.values()) {
                maxFreq = Math.max(maxFreq, freq);
            }
            while((right-left+1)-maxFreq >k){
                char comp = s.charAt(left);
                map.put(comp,map.get(comp)-1);
                if(map.get(comp)==0){
                    map.remove(comp);
                }
                left++;
                maxFreq = 0;
                for (int freq : map.values()) {
                    maxFreq = Math.max(maxFreq, freq);
                }
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}