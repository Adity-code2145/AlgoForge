class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root,null);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int dist = 0;
        while(!q.isEmpty()){
            if(dist == k){
                break;
            }
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && set.add(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right!=null && set.add(curr.right)){
                    q.add(curr.right);
                }
                if(map.get(curr)!=null && set.add(map.get(curr))){
                    q.add(map.get(curr));
                }
            }
            dist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    public void build(TreeNode root, TreeNode par){
        if(root ==null){
            return;
        }
        map.put(root,par);
        build(root.left,root);
        build(root.right,root);
    }
}