class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        result(root,ans);
        return ans;
    }
    public static void result(TreeNode root, List<Integer> ans){
        if(root == null) return;
        result(root.left,ans);
        result(root.right, ans);
        ans.add(root.val);
    }
}