class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        print(n,0,0,"",ans);
        return ans;
    }
    public void print(int n, int l, int r, String s, List<String> ans){
        if(r == n){
            ans.add(s);
            return;
        }
        if(l<n) print(n, l+1,r,s+'(', ans);
        if(l>r) print(n, l,r +1 , s+')', ans);
    }
}