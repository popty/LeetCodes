class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i = 0, j = 0;
        while(i<pushed.length){
            stk.push(pushed[i++]);
            while(!stk.empty() && stk.peek() == popped[j]){
                j++;
                stk.pop();
            }
        }
        
        return j == popped.length;
        
    }
}