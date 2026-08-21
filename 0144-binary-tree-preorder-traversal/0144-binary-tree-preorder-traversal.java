class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        result(root, ans);
        return ans;
    }
    public static void result(TreeNode root, List<Integer> ans){
        if(root == null) return;
            ans.add(root.val);
            result(root.left,ans);
            result(root.right,ans);
    }
}