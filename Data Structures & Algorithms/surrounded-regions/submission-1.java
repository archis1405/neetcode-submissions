class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            if(board[i][0]=='O'){
                queue.add(new int[]{i,0});
                visited[i][0] = 1;
            }
            if(board[i][m-1]=='O'){
                queue.add(new int[]{i,m-1});
                visited[i][m-1] = 1;
            }
        }

        for(int i=0 ; i<m ; i++){
            if(board[0][i]=='O'){
                queue.add(new int[]{0,i});
                visited[0][i] = 1;
            }
            if(board[n-1][i]=='O'){
                queue.add(new int[]{n-1,i});
                visited[n-1][i] = 1;
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int i=0 ; i<4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(valid(nr,nc,n,m) && board[nr][nc]=='O' && visited[nr][nc]==0){
                    visited[nr][nc] = 1;
                    queue.add(new int[]{nr , nc});
                }
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
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
