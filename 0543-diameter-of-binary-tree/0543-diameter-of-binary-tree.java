class Solution {
    int maxdia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxdia;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        maxdia = Math.max(maxdia,left+right);
        return 1+ Math.max(left,right);
    }
}