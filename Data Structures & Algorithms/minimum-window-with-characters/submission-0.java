class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        int[] required = new int[128];
        for(int i=0 ; i<t.length() ; i++){
            required[t.charAt(i)-'A']++;
        }

        int l = 0;
        int r = 0;

        int formed = 0;
        int requiredCnt = t.length();
        int minLen = Integer.MAX_VALUE;
        int i = 0;

        while(r<s.length()){
            char c = s.charAt(r);

            if(required[c-'A']>0){
                requiredCnt--;
            }

            required[c-'A']--;
            r++;

            while(requiredCnt==0){
                if(r-l<minLen){
                    minLen = r-l;
                    i = l;
                }

                char leftChar = s.charAt(l);

                required[leftChar-'A']++;

                if(required[leftChar-'A']>0){
                    requiredCnt++;
                }
                l++;
            }
        } 

        if(minLen==Integer.MAX_VALUE){
            return "";
        }

        return s.substring(i , i+minLen);
    }
}
