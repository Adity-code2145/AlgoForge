class Solution {
    static boolean ans;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        ans = true;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        for(int i =0;i<n;i++){
          
            if(vis[i] == -1) bfs(i,graph,vis);
        }
        return ans;
    }
    public void bfs(int i, int[][] graph, int[] vis){
        int n = graph.length;
        vis[i] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            int color = vis[front];
            for(int ele : graph[front]){
                if(vis[ele] == -1){
                    vis[ele] = 1-color;
                    q.add(ele);
                }
                if(vis[ele] == vis[front]){
                    ans = false;
                    return;
                }
            }
        }
    }
}