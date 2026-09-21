class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(int i=0 ; i<strs.size() ; i++){
            encoded.append(strs.get(i).length()).append('#').append(strs.get(i));
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i=0;

        while(i<str.length()){
            int j = i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            i = j + 1;
            j = i + len;

            ans.add(str.substring(i , j));

            i = j;
        }

        return ans;
    }
}
