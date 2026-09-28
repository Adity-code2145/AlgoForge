class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxcount = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
                maxcount = Math.max(count,maxcount);
            }
            else if(ch == ')'){
                count--;
            }
        }
        return maxcount;
    }
}