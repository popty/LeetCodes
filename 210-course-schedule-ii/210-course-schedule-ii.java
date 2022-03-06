class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      
        Map<Integer, List<Integer>> adjList = new HashMap<>();
       
        int[] indegrees = new int[numCourses];
        
        Queue<Integer> bfs = new LinkedList<>();
        
        int[] result = new int[numCourses];
        
        for(int[] pre : prerequisites){
            List<Integer> dependents = 
                adjList.getOrDefault(pre[1], new ArrayList<>());
            
            dependents.add(pre[0]);
            
            adjList.put(pre[1], dependents);
            
            indegrees[pre[0]]++;
        }
        
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i] == 0) bfs.offer(i);
        }
        
        int i = 0;
        
        while(!bfs.isEmpty()){
            int node = bfs.poll();
            result[i++] = node;
            List<Integer> dependents = 
                adjList.getOrDefault(node, new ArrayList<>());
            for(Integer dependent: dependents){
                indegrees[dependent]--;
                if(indegrees[dependent] == 0)bfs.offer(dependent);
            }
        }
        
        if(i!=numCourses) return new int[0];
        
        return result ;
        
        
    }
}