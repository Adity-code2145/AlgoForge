class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int count =0;
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                bfs(i,vis,adj);
                count++;
            }
        }
        return count;
    }
    public void bfs(int i, boolean[] vis, int[][] adj){
        int n = adj.length;
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j =0;j<n;j++){
                if(adj[front][j] == 1 && vis[j] == false){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}