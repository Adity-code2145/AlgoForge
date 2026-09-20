class Solution {
    public class Triplet implements Comparable<Triplet>{
        int row;
        int col;
        int effort;
        Triplet(int row,int col,int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
            public int compareTo(Triplet t){
                if(this.effort == t.effort) return this.row - t.row;
                return this.effort - t.effort;
            }
        
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][n];
       for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0,0,0));
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            int row = top.row;
            int col = top.col;
            int effort = top.effort;
            // upper side
            if(row>0){
                int e = Math.abs(heights[row][col] - heights[row-1][col]);
                e = Math.max(e,effort);
                if(ans[row-1][col] > e){
                    ans[row-1][col] = e;
                    pq.add(new Triplet(row-1,col,e));
                }
            }
            // down side
            if(row<m-1){
                int f = Math.abs(heights[row][col] - heights[row+1][col]);
                f = Math.max(f,effort);
                if(ans[row+1][col] > f){
                    ans[row+1][col] = f;
                    pq.add(new Triplet(row+1,col,f));
                }
            }
            // left
            if(col>0){
                int g = Math.abs(heights[row][col] - heights[row][col-1]);
                g = Math.max(g,effort);
                if(ans[row][col-1]>g){
                    ans[row][col-1] = g;
                    pq.add(new Triplet(row,col-1,g));
                }
            }
            //right
            if(col<n-1){
                int k = Math.abs(heights[row][col] - heights[row][col+1]);
                k = Math.max(k,effort);
                if(ans[row][col+1]>k){
                    ans[row][col+1] = k;
                    pq.add(new Triplet(row,col+1,k));
                }
            }
        }
        return ans[m-1][n-1];
    }
}