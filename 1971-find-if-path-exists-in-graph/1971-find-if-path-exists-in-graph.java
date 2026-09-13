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
            adj.get(a).add(b); // means -> a me add kardo b ko
            adj.get(b).add(a); // means -> b me add kardo a ko
        }
        boolean[] vis = new boolean[n];
        vis[start] = true;
        bfs(vis,adj,start,end);
        return vis[end];
    }
    public void bfs(boolean[] vis , List<List<Integer>> adj, int start, int end){
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele] = true;
                    // if(ele == end) return;
                }
            }
        }
    }
}