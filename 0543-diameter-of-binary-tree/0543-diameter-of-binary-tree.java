class Solution {
    int maxdia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root == null) return;
        dfs(root);
        return maxdia;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftdia = dfs(root.left);
        int rightdia = dfs(root.right);
        maxdia = Math.max(maxdia, leftdia+rightdia);
        return 1 + Math.max(leftdia,rightdia);
    }
}