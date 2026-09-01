class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        print(root,ans,0);
        return ans;   
    }
    public void print(TreeNode root, List<Integer> ans, int level){
        if(root == null) return;
        if(ans.size()<=level){
            ans.add(root.val);
        }
        else{
            ans.set(level,root.val);
        }
        print(root.left, ans, level+1);
        print(root.right,ans, level+1);
    }
}