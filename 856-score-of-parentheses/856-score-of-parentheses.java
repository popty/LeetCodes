class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int cur = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                stk.push(cur);
                cur = 0;
            }else{
                cur = stk.pop() + Math.max(2*cur, 1);
            }
        }
        return cur;
    }
}