class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            adj.add(list);
        }

        for(int i =0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        vis[start] = true;
        bfs(start,end,vis,adj);
        return vis[end];
    }
    public void bfs(int start,int end, boolean[] vis, List<List<Integer>> adj){
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }
}