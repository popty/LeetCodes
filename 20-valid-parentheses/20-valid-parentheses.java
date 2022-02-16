class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack();
        for(char c: s.toCharArray()){
            if(c == '('){
                stk.push(')');
            }
            
            else if(c == '{'){
                stk.push('}');
            }
            
            else if(c == '['){
                stk.push(']');
            }
            else{
                if(stk.isEmpty() || c != stk.peek()) return false;
                stk.pop();
            }
        }
        
        return stk.isEmpty();
    }
}