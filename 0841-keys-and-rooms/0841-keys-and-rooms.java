class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        bfs(0,adj,vis);
        for(boolean ele : vis){
            if(ele == false) return false;
        }
        return true;
    }
    public void bfs(int start, List<List<Integer>> adj, boolean[] vis){
        int n = adj.size();
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