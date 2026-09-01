class Solution {
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return dfs(root,min,max);
    }
    private boolean dfs(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }
        boolean left = dfs(root.left, min, root.val);
        boolean right = dfs(root.right,root.val, max);
        
        return left && right;
    }
}