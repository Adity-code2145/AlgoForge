class Solution {
    public int pathSum(TreeNode root, int tar) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,tar,0L,map);
    }
    public int dfs(TreeNode root,int tar, long prefixsum,HashMap<Long,Integer> map){
        if(root == null){
            return 0;
        }
        prefixsum += root.val;
        int count = map.getOrDefault(prefixsum-tar,0);

        map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);

        count += dfs(root.left,tar,prefixsum,map);
        count += dfs(root.right,tar,prefixsum,map);

        map.put(prefixsum,map.get(prefixsum)-1);
        return count;
    }
}