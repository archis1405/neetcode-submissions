class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //STEP 1 : Put all the element,freq in a map 
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
        }

        //STEP 2 : Define a Min heap and sort the min heap on basis of the freq of the element
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        //STEP 3 : Store k elements in the min heap from the map
        for(int n : map.keySet()){
            minHeap.add(n);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            ans[i] = minHeap.poll();
            i++;
        }

        return ans;
    }
}
