class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for(char c : s.toCharArray()){
            hs.put(c, hs.getOrDefault(c,0) + 1);
        }
        for(char c  : t.toCharArray()){
            if(!hs.containsKey(c)) return false;
            hs.put(c, hs.get(c)-1);
        }
        for(Integer k : hs.values()){
            if(k != 0) return false;
        }
        return true;
    }
}
