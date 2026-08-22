class Solution {
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        LineSum(root);
        return maxSum;
    }
    public int LineSum(TreeNode root){
        if(root == null) return 0;
        int leftSum = LineSum(root.left);
        int rightSum = LineSum(root.right);
        int pathsum = root.val;
        if(leftSum>0) pathsum += leftSum;
        if(rightSum>0) pathsum += rightSum;
        maxSum = Math.max(pathsum, maxSum);
        return root.val + Math.max(0, Math.max(leftSum, rightSum));
    }
}