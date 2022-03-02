class Solution {
    
    int n;
  
    private void helper(List<String> result, int open, int close, String sb){
     
       if(sb.length() == 2*n){
           result.add(sb);
           return;
       }
        
       if(open < n){
           helper(result, open+1, close, sb+"(");
       }
        
      if(close < open){
          helper(result, open, close+1, sb+")");
      }
        
     
      
       return;
       
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        this.n = n;
        helper(result, 0, 0, new String());
        return result;
    }
}