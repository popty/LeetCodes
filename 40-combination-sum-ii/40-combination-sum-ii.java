class Solution {
    
    HashSet<List<Integer>> set;
    int[] candidates;
    
    private void helper(Set<List<Integer>> result, int index, int target, LinkedList<Integer> temp){
        
        
        
        if(target < 0) return;
        
        if(target == 0){
            result.add(new ArrayList<>(temp));
        }
        
        for(int i = index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1])continue;
            temp.add(candidates[i]);
            helper(result, i+1, target - candidates[i], temp);
            temp.removeLast();
        }
        
        return;
        
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.set = new HashSet<>();
        
        
        LinkedList<Integer> temp = new LinkedList<>();
        Set<List<Integer>> result = new HashSet<>();
        helper(result, 0, target, temp);
        return new ArrayList<List<Integer>>(result);
    }
}