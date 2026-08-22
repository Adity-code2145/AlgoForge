class Solution {
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        flag = true;
        view(root);
        return flag;
    }
    public int view(TreeNode root){
        if(root==null) return 0;
        int leftsum = view(root.left);
        int rightsum = view(root.right);
        if(Math.abs(leftsum-rightsum)>1) flag = false;
        return 1 + Math.max(leftsum,rightsum);
    }
}