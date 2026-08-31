class Solution {
    static int maxdia;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxdia = 0;
        dia(root);
        return maxdia;
    }
    public int dia(TreeNode root){
        if(root == null) return 0;
        int leftsum = dia(root.left);
        int rightsum = dia(root.right);
        int sum = leftsum+rightsum;
        maxdia = Math.max(sum,maxdia);
        return 1+Math.max(leftsum,rightsum);
    }
}