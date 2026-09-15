class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(0 , nums, ans, curr);

        return ans;
    }

    public void solve(int i, int[] nums, List<List<Integer>> ans, List<Integer> curr){
        if(i==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);

        solve(i+1 , nums , ans, curr);
        curr.remove(curr.size()-1);


        for(int j=i+1 ; j<nums.length ; j++){
            if(nums[j]!=nums[i]){
                solve(j,nums,ans,curr);
                return;
            }
        }

        solve(nums.length , nums , ans , curr);
    }
}
