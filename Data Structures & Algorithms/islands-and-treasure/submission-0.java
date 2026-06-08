class Solution {
    int[][] grid;
    int m,n;
    private void dfs(int i, int j, int c){
        if(i < 0 || i == m 
            || j < 0 || j == n 
            || grid[i][j] == -1
            || grid[i][j] <= c) return;
        grid[i][j] = c;
        dfs(i+1,j,c+1);
        dfs(i-1,j,c+1);
        dfs(i,j+1,c+1);
        dfs(i,j-1,c+1);
        return;
    }
    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0){
                    dfs(i+1,j,1);
                    dfs(i-1,j,1);
                    dfs(i,j+1,1);
                    dfs(i,j-1,1);
                }
            }
        }
        return;
    }
}
