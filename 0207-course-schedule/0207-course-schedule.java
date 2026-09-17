class Solution {
    static boolean ans;
    public boolean canFinish(int n, int[][] mat) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i =0;i<mat.length;i++){
            int a = mat[i][0];
            int b = mat[i][1];
            adj.get(a).add(b);
            indegree[b]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            count++;

            for(int ele : adj.get(curr)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        return count == n;
    }
}