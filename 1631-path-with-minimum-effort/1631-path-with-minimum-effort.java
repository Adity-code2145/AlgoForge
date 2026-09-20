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
        int[] r = {-1,0,1,0};
        int[] c = {0,-1,0,1};
        pq.add(new Triplet(0,0,0));
        while(!pq.isEmpty()){
            Triplet top = pq.remove();
            int row = top.row;
            int col = top.col;
            int effort = top.effort;
            if(row == m-1 && col == n-1) break;
            for(int i =0;i<=3;i++){
                int newrow = row + r[i];
                int newcol = col + c[i];
                if(newrow<0 || newcol<0 || newrow>m-1 || newcol>n-1) continue;
                int e = Math.abs(heights[row][col] - heights[newrow][newcol]);
                e = Math.max(e,effort);
                if(ans[newrow][newcol]>e){
                    ans[newrow][newcol] = e;
                    pq.add(new Triplet(newrow,newcol,e));
                }
            }
        }
        return ans[m-1][n-1];
    }
}