class Solution {
    List<List<String>> res;
    int n;
    String s;
    private boolean isPalindrome(String s){
        int n = s.length()-1;
        int i = 0;
        while(i<n) if(s.charAt(i++) != s.charAt(n--)) return false;
        return true;
    }
    private void backtrack (int i, int currSize, StringBuilder sb, List<String> curr){
        // System.out.println(i +  " " + currSize + " " + sb.toString());
        if(i == n && currSize == n && isPalindrome(sb.toString())) {
            res.add(new ArrayList(curr));
            return;
        }
        if(i == n) return;
        sb.append(s.charAt(i));
        if(isPalindrome(sb.toString())){
            curr.add(sb.toString());
            backtrack(i+1,currSize+sb.length(), new StringBuilder(),curr);
            curr.remove(curr.size()-1);
        }
        backtrack(i+1,currSize,sb,curr);
        // System.out.println(currSize + " " +  sb.toString());
        
        return;

    }
    public List<List<String>> partition(String s) {
        this.res = new ArrayList<>();
        this.n = s.length();
        this.s = s;
        backtrack(0,0,new StringBuilder(),new ArrayList());
        return res;
    }
}