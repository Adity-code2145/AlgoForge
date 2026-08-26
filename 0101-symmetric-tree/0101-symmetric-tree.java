class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return adi(root.left,root.right);
    }
    public boolean adi(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;
        return adi(t1.left, t2.right) && adi(t1.right,t2.left);
    }
}