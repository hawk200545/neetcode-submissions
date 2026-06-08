class Solution {
    static char[][] board;
    static String word;
    static int m,n;
    static boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    this.vis = new boolean[m][n];
                    if(dfs(i,j,0)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int i, int j, int idx){
        if(i < 0 || j < 0 || i == m || j == n || vis[i][j] || board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length()-1) return true;
        vis[i][j] = true;
        boolean ans = dfs(i-1,j,idx+1) || dfs(i+1,j,idx+1) || dfs(i,j+1,idx+1) || dfs(i,j-1,idx+1);
        vis[i][j] = false;
        return ans;
    }

}
