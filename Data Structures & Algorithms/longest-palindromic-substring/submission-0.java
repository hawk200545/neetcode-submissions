class Solution {
    int[] curr;
    String s;
    public String longestPalindrome(String s) {
        this.curr = new int[2];
        this.s = s;
        longPal(0,0);
        return s.substring(curr[0],curr[1] + 1);
    }
    private void longPal(int i, int j){
        // System.out.println(i+ " " +j);
        int n = s.length();
        if(i < 0 || j == s.length()) return;
        int currSize = j-i+1;
        int maxSize = curr[1] - curr[0] + 1;
        if(s.charAt(i) == s.charAt(j)){
            if(maxSize <= currSize){
                curr[0] = i;
                curr[1] = j;
            }
            longPal(i-1,j+1);
            if(i == j){
                longPal(i+1,j+1);
                longPal(i-1, j);
                longPal(i,j+1);
            }
        }
        return;
    }
}