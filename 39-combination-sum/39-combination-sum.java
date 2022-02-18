class Solution {
    int[] candidates;
    
    protected void backtrack(
        int remain,
        LinkedList<Integer> comb, 
        int start, 
        List<List<Integer>> results){
        if(remain == 0){
            results.add(new ArrayList<>(comb));
            return;
        }
        
        if(remain < 0) return;
        
        for(int i = start; i< candidates.length; i++){
            comb.add(candidates[i]);
            backtrack(remain-candidates[i], comb, i, results);
            comb.removeLast();
        }
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        backtrack(target, comb, 0, results);
        return results;
    }
}