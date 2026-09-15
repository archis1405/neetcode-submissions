class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();

        for(int i=0 ; i<nums.length ; i++){
            map.add(nums[i]);
        }

        int len = 0;
        int maxLen = 0;

        for(int i : map){

            if(!map.contains(i-1)){
                int currElement = i;

                len = 1;

                while(map.contains(currElement+1)){
                    len++;
                    currElement++;
                }
            }

            maxLen = Math.max(len , maxLen);
        }

        return maxLen;

    }
}
