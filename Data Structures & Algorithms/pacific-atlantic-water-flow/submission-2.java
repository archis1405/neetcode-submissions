class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacificVisited = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];

        for(int i=0 ; i<m ; i++){
            dfs(0,i,heights,pacificVisited);
        }
        for(int i=0 ; i<n ; i++){
            dfs(i,0,heights,pacificVisited);
        }

        for(int i=0 ; i<n ; i++){
            dfs(i,m-1,heights,atlanticVisited);
        }
        for(int i=0 ; i<m ; i++){
            dfs(n-1,i,heights,atlanticVisited);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(pacificVisited[i][j]==true && atlanticVisited[i][j]==true){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    public void dfs(int r, int c, int[][] heights , boolean[][] visited){

        if(visited[r][c]==true){
            return;
        }

        visited[r][c] = true;

        int n = heights.length;
        int m = heights[0].length;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for(int i=0 ; i<4 ; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isValid(nr,nc,n,m) && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,heights,visited);
            }
        }
    }

    public boolean isValid(int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }

        return true;
    }
}
