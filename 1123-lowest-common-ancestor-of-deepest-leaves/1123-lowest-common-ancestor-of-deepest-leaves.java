class Solution {
    static class Pair{
        TreeNode node;
        int height;
        Pair(TreeNode node,int height){
            this.node = node;
            this.height = height;
        } 
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    public Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(null,0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if(left.height == right.height){
            return new Pair(root,left.height+1);
        }
        else if(left.height > right.height){
            return new Pair(left.node,left.height+1);
        }
        else{
            return new Pair(right.node,right.height+1);
        }
    }
}