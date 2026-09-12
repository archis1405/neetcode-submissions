class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;

        int maxLen = 0;
        int len = 0;

        HashMap<Character , Integer> map = new HashMap<>();

        while(r<s.length()){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r))>=l){
                int index = map.get(s.charAt(r));
                l = index+1;
            }
            
            map.put(s.charAt(r) , r);
            len = r-l+1;
            
            maxLen = Math.max(len , maxLen);

            r++;
        }

        return maxLen;
    }
}
