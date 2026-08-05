class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hs = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(hs.containsKey(sorted)){
                hs.get(sorted).add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                hs.put(sorted, list);
            }
        }
        return new ArrayList<>(hs.values());
    }
}
