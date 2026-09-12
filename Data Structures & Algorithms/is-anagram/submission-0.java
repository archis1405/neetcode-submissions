class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] hashA = new int[26];
        int[] hashB = new int[26];

        for(int i=0 ; i<s.length() ; i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            hashA[ch1-'a']++;
            hashB[ch2-'a']++;
        }

        for(int i=0 ; i<26 ; i++){
            if(hashA[i] != hashB[i]){
                return false;
            }
        }

        return true;
    }
}
