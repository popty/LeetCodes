class Solution {
    
    int[] candidates;
    
    public void helper(List<List<Integer>> list, int target, int index, 
                      LinkedList<Integer> tempList){
        
        
        
        if(target < 0 || index >= candidates.length) return;
        
        if(target == 0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        
       
        for(int i = index; i<candidates.length; i++){
            tempList.add(candidates[i]);
            helper(list, target - candidates[i], i, tempList);
            tempList.removeLast();
        }
       
        
        
        
        return;
        
        
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        this.candidates = candidates;
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> tempList = new LinkedList<>();
        helper(list, target, 0, tempList);
        return list;
    }
}