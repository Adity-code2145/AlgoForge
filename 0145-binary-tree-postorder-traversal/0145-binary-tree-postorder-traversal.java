class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postord(root,ans);
        return ans;
    }
    public void postord(TreeNode root, List<Integer> ans){
        if(root == null) return;
        postord(root.left,ans);
        postord(root.right,ans);
        ans.add(root.val);
    }
}