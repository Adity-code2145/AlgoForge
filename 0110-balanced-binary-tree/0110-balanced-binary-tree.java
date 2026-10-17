class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        flag = true;
        dfs(root);
        return flag;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftsum = dfs(root.left);
        int rightsum = dfs(root.right);
        if(Math.abs(leftsum-rightsum)>1) flag = false;
        return 1 + Math.max(leftsum,rightsum);
    }
}