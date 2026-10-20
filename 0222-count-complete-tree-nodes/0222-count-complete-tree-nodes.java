class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftheight = leftHeight(root);
        int rightheight = rightHeight(root);

        if(leftheight == rightheight){
            return (int) Math.pow(2,leftheight) -1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int leftHeight(TreeNode root){
        int h = 0;
        while(root!=null){
            h++;
            root = root.left;
        }
        return h;
    }
    public int rightHeight(TreeNode root){
        int h = 0;
        while(root != null){
            h++;
            root = root.right;
        }
        return h;
    }
}