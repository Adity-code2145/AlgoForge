class Solution {
    public List<Integer> spiralOrder(int[][] M) {
        List<Integer> ans = new ArrayList<>();
        
        int [][] dir = {{0 , 1} , {1 , 0} , {0 , -1} , {-1 , 0}};

        int n = M.length , m = M[0].length;
        boolean [][]vis = new boolean[n + 1][m + 1];
        int inx = 0;
        int i = 0 , j = 0;
        
        if(n == 1) {
            for(int jj = 0; jj < M[0].length; ++jj)
            ans.add(M[0][jj]);

            return ans; 
        }    

        if(m == 1) {
            for(int jj = 0; jj < M.length; ++jj)
            ans.add(M[jj][0]);

            return ans;             
        }

        while(true) {
            ans.add(M[i][j]);
            vis[i][j] = true;

            int ix = i + dir[inx][0] , jx = j + dir[inx][1];

            if(ix >= n || ix < 0 || jx >= m || jx < 0 || vis[ix][jx]) {
                inx++; inx %= dir.length;

                ix = i + dir[inx][0] ; jx = j + dir[inx][1];

                if(ix > n || ix < 0 || jx > m || jx < 0 || vis[ix][jx])
                   return ans;
            } 

            i = ix; j = jx;
        }
    }
}