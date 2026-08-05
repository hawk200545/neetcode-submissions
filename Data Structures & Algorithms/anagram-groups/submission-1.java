class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hs = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            hs.putIfAbsent(sorted, new ArrayList<>());
            hs.get(sorted).add(s);
        }
        return new ArrayList<>(hs.values());
    }
}
