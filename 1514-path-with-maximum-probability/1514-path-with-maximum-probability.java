class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        double prob;
        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
        public int compareTo(Pair p){
            if(this.prob == p.prob) return this.node-p.node;
            return Double.compare(this.prob,p.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            adj.get(a).add(new Pair(b,prob));
            adj.get(b).add(new Pair(a,prob));
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start,1));
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int node = top.node;
            double prob = top.prob;
            //if(top.prob < ans[node]) continue;
            for(Pair p : adj.get(node)){
                double totalprob = prob * p.prob;
                if(ans[p.node] < totalprob){
                    ans[p.node] = totalprob;
                    pq.add(new Pair(p.node,totalprob));
                }
            }
        }
        return ans[end];
    }
}