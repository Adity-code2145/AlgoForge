class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        print(n,ans,0,0,"");
        return ans;
    }
    public void print(int n, List<String> ans,int left, int right, String curr){
        if(right == n){
            ans.add(curr);
            return;
        }
        if(left>right) print(n, ans,left,right+1,curr+ ')');
        if(left<n) print(n,ans,left+1,right,curr+ '(');
    }
}