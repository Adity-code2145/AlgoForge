class Solution {
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        LineSum(root);
        return maxSum;
    }
    public int LineSum(TreeNode root){
        if(root == null) return 0;
        int leftsum = LineSum(root.left);
        int rightsum = LineSum(root.right);
        int pathsum = root.val;
        if(leftsum >0) pathsum += leftsum;
        if(rightsum>0) pathsum += rightsum;
        maxSum = Math.max(maxSum, pathsum);
        return root.val + Math.max(0,Math.max(leftsum,rightsum));
    }
}