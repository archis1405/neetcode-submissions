class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                visited[i][j] = 0;
            }
        }

        int cnt = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    dfs(i,j,grid,visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int r, int c, char[][] grid, int[][] visited){
        visited[r][c] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i=0 ; i<4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(valid(nr,nc,n,m) && grid[nr][nc]=='1' && visited[nr][nc]==0){
                dfs(nr,nc,grid,visited);
            }
        }
    }

    public boolean valid(int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }

        return true;
    }
}
