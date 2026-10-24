class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double ans = 0;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                ans += curr.val;
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }

            }
            list.add(ans/size);
        }
        return list;        
    }
}