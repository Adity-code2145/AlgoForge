class Solution {
    int count =0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        dfs(root, max);
        return count;
    }
    public void dfs(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max){
            count++;
        }
        max = Math.max(root.val,max);

        dfs(root.left,max);
        dfs(root.right,max);
    }
}