class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int count = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                   count++;
                }
            }
        }
        int time = 0;
        int[][] dir = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1},
        };
        while(!q.isEmpty() && count>0){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                for(int[] dirc : dir){
                    int nr = r + dirc[0];
                    int nc = c + dirc[1];
                    if(nr>=0 && nr<n && nc >=0 && nc<m && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        count--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            time++;
        }
        if(count > 0) return-1;
        return time;
    }
}