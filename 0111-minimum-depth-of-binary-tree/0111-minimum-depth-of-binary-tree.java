class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftmin = Integer.MAX_VALUE;
        int rightmin = Integer.MAX_VALUE;
        if(root.left != null){
            leftmin = minDepth(root.left);
        }
        if(root.right != null){
            rightmin = minDepth(root.right);
        }
        return 1 + Math.min(leftmin,rightmin);
    }
}