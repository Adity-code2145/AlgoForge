class Solution {
    public int[] findOrder(int n, int[][] mat) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0;i<mat.length;i++){
            int a = mat[i][0];
            int b = mat[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        while(!q.isEmpty()){
            int front = q.remove();
            ans[idx] = front;
            idx++;
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        if(idx != n){
            return new int[0];
        }
        return ans;
    }
}