class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0 ; i<prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean[] visited = new boolean[numCourses];
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree , 0);

        for(int i=0 ; i<numCourses ; i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        ArrayList<Integer> courseOrder = new ArrayList<>(); 

        while(!queue.isEmpty()){
            int curr = queue.poll();

            courseOrder.add(curr);

            for(int i : adj.get(curr)){
                indegree[i]--;

                if(indegree[i]==0){
                    queue.add(i);
                }
            }
        }

        int[] ans = new int[numCourses];

        if(courseOrder.size()!=numCourses){
            return new int[]{};
        }

        if(courseOrder.size()==numCourses){
            for(int i=0 ; i<numCourses ; i++){
                ans[i] = courseOrder.get(i);
            }
        }

        return ans;
    }
}
