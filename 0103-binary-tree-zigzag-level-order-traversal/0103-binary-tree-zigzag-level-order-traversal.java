class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean lefttoright = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(lefttoright){
                    level.addLast(node.val);
                }else{
                    level.addFirst(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right!=null)  q.add(node.right);
            }
            ans.add(level);
            lefttoright = !lefttoright;
        }
        return ans;
    }
}