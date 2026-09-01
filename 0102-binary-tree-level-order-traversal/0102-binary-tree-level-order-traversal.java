class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        print(root,0,ans);
        return ans;
    }
    public void print(TreeNode root, int level, List<List<Integer>> ans){
        if(root==null){
            return;
        }
        if(ans.size()==level){
            ans.add(new ArrayList<>());
        }
        
        ans.get(level).add(root.val);
        print(root.left,level+1,ans);
        print(root.right,level+1,ans);
    }
}