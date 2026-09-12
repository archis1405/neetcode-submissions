class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0] , b[0]));

        ArrayList<int[]> temp = new ArrayList<>();
        temp.add(new int[]{intervals[0][0] , intervals[0][1]});

        for(int i=1 ; i<intervals.length ; i++){
            int[] curr = temp.get(temp.size()-1);

            if(curr[1]>=intervals[i][0]){
                curr[1] = Math.max(curr[1] , intervals[i][1]);
            }
            else{
                temp.add(new int[]{intervals[i][0] , intervals[i][1]});
            }
        }

        int[][] ans = new int[temp.size()][2];
        for(int i=0 ; i<temp.size() ; i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
