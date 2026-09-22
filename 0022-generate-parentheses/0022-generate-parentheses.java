class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        adi(n,0,0,ans,"");
        return ans;
    }
    public void adi(int n, int left, int right,List<String> ans, String curr){
        if(right == n){
            ans.add(curr);
            return;
        }
        if(left>right) adi(n,left,right+1,ans,curr+')');
        if(left<n) adi(n,left+1,right,ans,curr+'(');
    }
}