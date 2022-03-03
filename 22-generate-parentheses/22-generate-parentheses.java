class Solution {
    
    private void helper(List<String> par, int open, int close, String str, int n){
        if(str.length() == 2*n){
            par.add(str);
            return;
        }
        
        if(open < n){
            helper(par, open+1, close, str+ "(", n);
        }
        
        if(close < open){
            helper(par, open, close+1, str+")", n);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> par = new ArrayList<>();
        helper(par, 0, 0, "", n);
        return par;
    }
}