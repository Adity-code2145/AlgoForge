class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(root,ans,curr,tar);
        return ans;
    }
    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> curr, int tar){
        if(root == null) return;
        curr.add(root.val);
        if(root.left == null && root.right == null && tar == root.val){
            ans.add(new ArrayList<>(curr));
        }
        if(root.left!= null) dfs(root.left,ans,curr,tar - root.val);
        if(root.right != null) dfs(root.right,ans,curr, tar - root.val);
        curr.remove(curr.size()-1);
    }
}