class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }
        for(int i = 0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        vis[source] = true;
        return dfs(source, destination, adj, vis);
    }
    public boolean dfs(int i, int j, List<List<Integer>> adj, boolean[] vis){
        if(i == j){
             return true;
        }     
        vis[i] = true;
        for(int ele : adj.get(i)){
            if(!vis[ele]){
                if(dfs(ele,j, adj,vis)){
                 return true;
                }
            }
        }
        return false;
    }
}