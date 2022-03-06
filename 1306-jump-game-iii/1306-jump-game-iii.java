class Solution {
    
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(arr[node] == 0) return true;
            visited.add(node);
            if(node+arr[node]< arr.length 
               && !visited.contains(node+arr[node])){
                queue.add(node+arr[node]);
            }
            
            if(node-arr[node] >= 0 && !visited.contains(node-arr[node])){
                queue.add(node-arr[node]);
            }
            
        }
      
        return false;
        
        
    }
}