class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(')chars.push(')');
            
            else if(c == '{') chars.push('}');
            
            else if(c == '[') chars.push(']');
            
            else{
                if(chars.isEmpty() || chars.peek() != c){
                    return false;
                }
                chars.pop();
            }
        }
        return chars.isEmpty();
    }
}