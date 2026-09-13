class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]==0){
                    queue.add(new int[]{i,j});
                }
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

                if(nc<0 || nr<0 || nr>=n || nc>=m){
                    continue;
                }

                if(grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = 1 + grid[r][c];
                queue.offer(new int[]{nr,nc});
            }
        }
    }
}
