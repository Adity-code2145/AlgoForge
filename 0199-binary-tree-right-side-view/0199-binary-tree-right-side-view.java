class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        level(root,0,ans);
        return ans;
    }
    public void level(TreeNode root, int level, List<Integer> ans){
        if(root == null) return;
        if(ans.size()<=level){
            ans.add(root.val);
        }else{
            ans.set(level,root.val);
        }
        level(root.left, level+1, ans);
        level(root.right, level+1,ans);
    }
}