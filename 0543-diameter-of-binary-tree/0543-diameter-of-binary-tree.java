class Solution {
    static int maxdia;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxdia = 0;
        diameter(root);
        return maxdia;
    }
    public int diameter(TreeNode root){
        if(root ==null) return 0;
        int leftsum = diameter(root.left);
        int rightsum = diameter(root.right);
        int sum = leftsum+rightsum;
        maxdia = Math.max(maxdia, sum);
        return 1 + Math.max(leftsum,rightsum);
    }
}