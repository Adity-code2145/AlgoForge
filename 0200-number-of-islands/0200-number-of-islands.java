class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i ,int j, boolean[][] vis, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        if(i-1>=0 && grid[i-1][j] == '1' && vis[i-1][j] == false){
            dfs(i-1,j,vis,grid);
        }
        if(i+1<m && grid[i+1][j] == '1' && vis[i+1][j] == false){
            dfs(i+1,j,vis,grid);
        }
        if(j-1>=0 && grid[i][j-1] == '1' && vis[i][j-1]== false){
            dfs(i,j-1,vis,grid);
        }
        if(j+1<n && grid[i][j+1] == '1' && vis[i][j+1]== false){
            dfs(i,j+1, vis, grid);
        }
    }
}