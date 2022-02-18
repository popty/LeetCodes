class Solution {
    public String removeKdigits(String num, int k) {
        
       StringBuilder sb = new StringBuilder();
       
        Stack<Character> stk = new Stack<>();
        
        for(char c: num.toCharArray()){
            while(!stk.empty() && k>0 && c<stk.peek()){
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        
        while(k-->0 && !stk.empty()){
            stk.pop();
        }
        
        int fact = 1;
        
        while(!stk.empty()){
            sb.append(stk.pop());
        }
        
        if(sb.toString() == "" || sb.toString() == "0") return "0";
        
        return sb.reverse().toString().replaceFirst("^0+(?!$)", "");
        
        
    }
}