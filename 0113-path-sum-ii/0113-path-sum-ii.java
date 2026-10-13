class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        dfs(root,ans,arr,tar);
        return ans;
    }
    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> arr, int tar){
        if(root == null) return;
        arr.add(root.val);

        if(root.left == null && root.right == null && tar == root.val){
           ans.add(new ArrayList<>(arr));
        }
        if(root.left != null) dfs(root.left,ans,arr,tar - root.val);
        if(root.right != null) dfs(root.right, ans, arr, tar - root.val);
        arr.remove(arr.size()-1);
    }
}