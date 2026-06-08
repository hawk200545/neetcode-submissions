class Solution {
    List<String> res;
    Map<Character,String> keypad = Map.of(
        '2' , "abc",
        '3' , "def",
        '4' , "ghi",
        '5' , "jkl",
        '6' , "mno",
        '7' , "pqrs",
        '8' , "tuv",
        '9' , "wxyz"
    );
    List<String> allKeys;
    int n;
    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        if (digits.equals("")) return res;
        this.n = digits.length();
        StringBuilder sb = new StringBuilder();
        this.allKeys = new ArrayList<>();
        for(char c : digits.toCharArray()) allKeys.add(keypad.get(c));
        combination(0,0,new StringBuilder());
        return res;
    }
    private void combination(int i, int j, StringBuilder sb){
        // System.out.println(sb.toString());
        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }
        if( j == allKeys.size()) return;
        if(i == allKeys.get(j).length()) return;
        sb.append(allKeys.get(j).charAt(i));
        combination(0,j+1,sb);
        sb.deleteCharAt(sb.length() -1);
        combination(i+1,j,sb);
        return;
    }
}   