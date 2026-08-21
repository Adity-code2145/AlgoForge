class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        result(root,ans);
        return ans;
    }
    public static void result(TreeNode root, List<Integer> ans){
        if(root == null) return;
        result(root.left,ans);
        ans.add(root.val);
        result(root.right,ans);
    }
}