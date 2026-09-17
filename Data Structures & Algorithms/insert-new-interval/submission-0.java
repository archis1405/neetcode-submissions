class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0;

        List<int[]> temp = new ArrayList<>();

        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            temp.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }

        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newStart = Math.min(newStart , intervals[i][0]);
            newEnd = Math.max(newEnd , intervals[i][1]);

            i++;
        }

        temp.add(new int[]{newStart , newEnd});

        while(i<intervals.length){
            temp.add(new int[]{intervals[i][0] , intervals[i][1]});
            i++;
        }

        int[][] ans = new int[temp.size()][2];

        for(int j=0 ; j<temp.size() ; j++){
            ans[j] = temp.get(j);
        }

        return ans;
    }
}
