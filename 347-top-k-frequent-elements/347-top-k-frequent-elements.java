class Solution {
    Map<Integer, Integer> count;
    int[] unique;
    
    private void swap(int a, int b){
        int temp = unique[a];
        unique[a] = unique[b];
        unique[b] = temp;
        
    }
    
    private int partition(int start, int end, int pivot_index){
        int pivot_freq = count.get(unique[pivot_index]);
        swap(pivot_index, end);
        int store_index = start;
        
        for(int i = start; i<=end; i++){
            if(count.get(unique[i]) < pivot_freq){
                swap(store_index, i);
                store_index++;
            }
        }
        
        swap(store_index, end);
        
        return store_index;
        
    }
   
    
    private void quickselect(int left, int right, int k_smallest){
        if(left < right){
            Random random = new Random();
            int pivot_index = left + random.nextInt(right-left);
            pivot_index = partition(left, right, pivot_index);
            if(pivot_index == k_smallest)
                return;
            
            else if(pivot_index > k_smallest)
                quickselect(left, pivot_index-1, k_smallest);
            else 
                quickselect(pivot_index+1, right, k_smallest);
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        count = new HashMap<>();
        
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        
        int n = count.size();
        
        unique = new int[n];
        
        int i = 0;
      
        for(int num: count.keySet()){
            unique[i++] = num;
        }
        
        quickselect(0, n-1, n-k);
        
        return Arrays.copyOfRange(unique, n-k, n);
        
        
    }
}