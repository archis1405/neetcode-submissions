class Solution {
    public int countComponents(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] visited = new int[n];
        Arrays.fill(visited , 0);

        int cnt = 0;

        for(int i=0 ; i<n ; i++){
            if(visited[i]==0){
                cnt++;
                dfs(i,adj,visited);
            }
        }

        return cnt;
    }

    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , int[] visited){
        visited[node] = 1;

        for(int i : adj.get(node)){
            if(visited[i]==0){
                dfs(i , adj , visited);
            }
        }
    }
}
