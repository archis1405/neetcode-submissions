class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i , j});
                }
                else if(grid[i][j]==1){
                    cnt++;
                }
            }
        }

        if(cnt==0){
            return 0;
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        int time = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0 ; i<size ; i++){
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for(int j=0 ; j<4 ; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(valid(nr,nc,n,m) && grid[nr][nc]==1){
                        queue.add(new int[]{nr , nc});
                        grid[nr][nc] = 2;
                    }
                }
            }

            if(!queue.isEmpty()){
                time++;
            }
            
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time;
    }

    public boolean valid(int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }

        return true;
    }
}
