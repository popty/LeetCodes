class Solution {
    
    
    private void backtrack(int n, ArrayList<Integer> num_list, 
                          List<List<Integer>> output, int start){
        
        if(start == n) {
            output.add(new ArrayList<Integer>(num_list));
            return;
        }
        
        for(int i = start; i<n; i++){
            Collections.swap(num_list, start, i);
            backtrack(n, num_list, output, start+1);
            Collections.swap(num_list, start, i);
        }
        
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> num_list = new ArrayList<Integer>();
        int n= nums.length;
        for(int num: nums)num_list.add(num);
        
        backtrack(n, num_list, output, 0);
        
        return output;
    }
}