class Solution { 
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root,null);
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        set.add(target);
        q.add(target);

        int dist = 0;
        while(!q.isEmpty()){
            if(dist == k){
                break;
            }
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && set.add(curr.left)){
                    q.add(curr.left);
                }
                if(curr.right != null && set.add(curr.right)){
                    q.add(curr.right);
                }
                if(map.get(curr) != null && set.add(map.get(curr))){ // here we add parent.
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

    public void build(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }
        map.put(root,parent);
        build(root.left,root);
        build(root.right,root);
    }
}