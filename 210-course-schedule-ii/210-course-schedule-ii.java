/*
Algorithm:
  1. Prepare an adjacency list i.e. for each bi, all the ai that depend on it. 
 2. Calculate indegrees of each course
 3. Add those courses with 0 indegrees to a queue. 
 4. Pop the queue add to resultant topological sort array. reduce in degrees of all dependent courses by 1. if any course gets reduced to 0 indegree add it to queue


*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int[] topological = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int[] pre: prerequisites){
            List<Integer> dependents = map.getOrDefault(pre[1], new ArrayList<>());
            dependents.add(pre[0]);
            map.put(pre[1], dependents);
            indegrees[pre[0]]++;
        }
        
        for(int i = 0; i<numCourses; i++){
            if(indegrees[i] == 0)queue.offer(i);
        }
        
        int i = 0;
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            topological[i++] = course;
            List<Integer> dependents = map.getOrDefault(course, new ArrayList<>());
            for(Integer dependent: dependents){
                indegrees[dependent]--;
                if(indegrees[dependent] == 0)queue.offer(dependent);
            }
            
        }
        
        return i == numCourses ? topological : new int[0];
        
        
    }
}