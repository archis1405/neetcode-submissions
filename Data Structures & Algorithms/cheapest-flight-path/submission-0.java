class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<flights.length ; i++){
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];

            adj.get(from).add(new int[]{to , cost});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,src,0}); // number_of_stops , to , cost

        int[] ans = new int[n];
        Arrays.fill(ans , Integer.MAX_VALUE);

        ans[src] = 0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];

            for(int[] i : adj.get(node)){
                int nextNode = i[0];
                int nextNodeCost = i[1];

                if(cost+nextNodeCost < ans[nextNode] && stops<=k){
                    ans[nextNode] = cost+nextNodeCost;

                    queue.add(new int[]{stops+1 , nextNode , cost+nextNodeCost});
                }
            }
        }

        if(ans[dst]==Integer.MAX_VALUE){
            return -1;
        }

        return ans[dst];
    }
}
