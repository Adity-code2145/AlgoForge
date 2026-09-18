class Solution {
    static boolean ans;
    public boolean canFinish(int n, int[][] pre) {
        ans = true; // if there is no cycle
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<pre.length;i++){
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
           // adj.get(a).add(b);
        }
        boolean[] path = new boolean[n];
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(vis[i]== false){
                dfs(i,vis,path,adj);
            }
        }
        return ans;
    }
    public void dfs(int i, boolean[] vis, boolean[] path,List<List<Integer>> adj){
        vis[i] = true;
        path[i] = true;
        for(int ele : adj.get(i)){
            if(path[ele] == true){ // cycle detect
                ans = false;
                return;
            }
            if(vis[ele]== false) dfs(ele,vis,path,adj);
        }
        path[i] = false;
    }
}