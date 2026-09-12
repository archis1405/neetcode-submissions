class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;

        int maxLen = 0;
        int len = 0;

        int maxFreq = 0;

        int[] freq = new int[26];
        Arrays.fill(freq , 0);

        while(r<s.length()){
            char c = s.charAt(r);

            freq[c-'A']++;

            maxFreq = Math.max(maxFreq , freq[c-'A']);
            len = r-l+1;

            while(len-maxFreq > k){
                freq[s.charAt(l)-'A']--;

                maxFreq = 0;

                for(int i=0 ; i<26 ; i++){
                    maxFreq = Math.max(maxFreq , freq[i]);
                }
                l++;
                len = r-l+1;
            }

            if(len-maxFreq <= k){
                maxLen = Math.max(maxLen , (r-l+1));
            }

            r++;
        }

        return maxLen;
    }
}
