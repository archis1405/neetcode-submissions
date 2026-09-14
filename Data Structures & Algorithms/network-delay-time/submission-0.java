class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<times.length ; i++){
            adj.get(times[i][0]).add(new int[]{times[i][1] , times[i][2]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0 , k});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            int time = curr[0];
            int node = curr[1];


            if(time>dist[node]){
                continue; // if the node already has a time smaller than the current time
            }

            for(int[] i : adj.get(node)){
                int nextNode = i[0];
                int timetoNext = i[1];

                if(time+timetoNext < dist[nextNode]){
                    dist[nextNode] = time+timetoNext;

                    queue.add(new int[]{dist[nextNode] , nextNode});
                }
            }
        }

        int ans = 0;

        for(int i=1 ; i<dist.length ; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            else{
                ans = Math.max(dist[i] , ans);
            }
        }

        return ans;
    }
}
