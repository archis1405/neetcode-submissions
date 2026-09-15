class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String curr = "";

        solve(0,0,n,ans,curr);

        return ans;
    }

    public void solve(int open, int close, int n, List<String> ans, String curr){
        if(open==close && open+close==2*n){
            ans.add(curr);
            return;
        }

        if(open<n){
            solve(open+1 , close , n , ans , curr+"(");
        }
        if(close<open){
            solve(open , close+1 , n , ans , curr+")");
        }
    }
}
