class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(0,candidates,target,ans,curr);

        return ans;
    }

    public void solve(int i, int[] nums, int target, List<List<Integer>> ans, List<Integer> curr){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(i==nums.length || target<0){
            return;
        }

        curr.add(nums[i]);

        solve(i+1 , nums , target-nums[i] , ans , curr);

        curr.remove(curr.size()-1);

        for(int j=i+1 ; j<nums.length ; j++){
            if(nums[j]!=nums[i]){
                solve(j , nums , target , ans , curr);
                break;
            }
        }
    }
}
