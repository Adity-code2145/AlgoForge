class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                if(flag){
                    level.addLast(node.val);
                }
                else{
                    level.addFirst(node.val);
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans.add(level);
            flag = !flag;
        }
        return ans;
    }
}