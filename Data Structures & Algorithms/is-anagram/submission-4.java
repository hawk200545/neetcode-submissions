class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Integer, Integer> hs1 = new HashMap<>();
        Map<Integer, Integer> hs2 = new HashMap<>();
        for (char c : s.toCharArray()){
            hs1.put(c-'a', hs1.getOrDefault(c-'a',0)+1);
        }
        for (char c : t.toCharArray()){
            hs2.put(c-'a', hs2.getOrDefault(c-'a',0)+1);
        }
        return hs1.equals(hs2);
    }
}
