class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] board,int i,int j) {
        int n = board.length;
        int m = board[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O') return;

        board[i][j] = 'T';
        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            dfs(board,nx,ny);
        }

    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            dfs(board,i,0);//left 
            dfs(board,i,m-1);//right
        }

        for(int j=0;j<m;j++){
            dfs(board,0,j); //right
            dfs(board,n-1,j); //bottom
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
}
