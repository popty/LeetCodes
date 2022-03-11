class Solution {
    
    String text1;
    String text2;
    Integer[][] memo;
    public int helper(int i, int j){
        if(i == text1.length() || j == text2.length()) return 0;
       
        if(memo[i][j] != null) return memo[i][j];
        

       if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1+helper(i+1, j+1);
            return memo[i][j];
        }


       return memo[i][j] = Math.max(helper(i+1, j), helper(i, j+1));
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        if(text1.length() < text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        
        this.text1 = text1;
        this.text2 = text2;
        
        this.memo = new Integer[this.text1.length()][this.text2.length()];
        
        return helper(0, 0);
    }
}