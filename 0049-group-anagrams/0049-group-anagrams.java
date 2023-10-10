class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String ch = String.valueOf(arr);
            if(hm.containsKey(ch)){
                List<String>s = hm.get(ch);
                s.add(strs[i]);
                hm.put(ch,s);
            }
            else{
                List<String>s = new ArrayList<String>();
                s.add(strs[i]);
                hm.put(ch,s);
            }

        }
        List<List<String>> st = new ArrayList<>();
        
        for (Map.Entry<String,List<String>> mapElement : hm.entrySet()) {
            
 
            st.add(mapElement.getValue());
            
        }
        return st;
        
    }
}