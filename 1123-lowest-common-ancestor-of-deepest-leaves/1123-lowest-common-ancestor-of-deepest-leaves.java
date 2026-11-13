class Solution {
    static class Pair{
        TreeNode node;
        int h;
        Pair(TreeNode node,int h){
            this.node = node;
            this.h = h;
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

        if(left.h == right.h){
            return new Pair(root,left.h+1);
        }
        else if(left.h>right.h){
            return new Pair(left.node,left.h+1);
        }
        else{
            return new Pair(right.node,right.h+1);
        }
    }
}