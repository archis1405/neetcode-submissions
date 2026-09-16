class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> curr = new ArrayList<>();

        solve(0,target,nums,curr,ans);

        return ans;
    }

    public void solve(int i, int target, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(i==nums.length || target<0){
            return;
        }

        curr.add(nums[i]);
        solve(i , target - nums[i] , nums , curr , ans);
        curr.remove(curr.size()-1);

        solve(i+1 , target , nums , curr , ans);
    }
}
