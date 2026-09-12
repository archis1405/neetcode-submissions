class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        if(strs.length==0){
            return ans;
        }

        HashMap<String , List<String>> map = new HashMap<>();

        for(String str : strs){
            String key = getKey(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(key,strList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static String getKey(String str){
        int[] freq = new int[26];

        for(int i=0 ; i<str.length() ; i++){
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        char ch = 'a';
        for(int i=0 ; i<26 ; i++){
            if(freq[i]!=0){
                ans.append(ch);
                ans.append(freq[i]);
            }
            ch++;
        }

        return ans.toString();
    }
}
