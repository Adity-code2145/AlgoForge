class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int right =0;right<s.length();right++){
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
            while(right-left+1>k){
                char remove = s.charAt(left);
                if(remove == 'a' || remove == 'e' || remove == 'i' || remove == 'o' || remove == 'u'){
                  count--;
                }
                left++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}