class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        Queue<Integer> bfs = new LinkedList<>();
        int[] result = new int[numCourses];
        
        for(int[] p: prerequisites){
            List<Integer> dependents  = adjList.getOrDefault(p[1], new ArrayList<>());
            dependents.add(p[0]);
            adjList.put(p[1], dependents);
            inDegrees[p[0]]++;
        }
        
        for(int i = 0; i<inDegrees.length; i++){
            if(inDegrees[i] == 0) bfs.offer(i);
        }
        
        int i = 0;
        while(!bfs.isEmpty()){
            int node = bfs.poll();
            result[i++] = node;
            List<Integer> dependents = adjList.getOrDefault(node, new ArrayList<>());
            for(Integer dependent: dependents){
                inDegrees[dependent]--;
                if(inDegrees[dependent] == 0)bfs.offer(dependent);
            }
        }
        
        return i==numCourses;
        
        
    }
}